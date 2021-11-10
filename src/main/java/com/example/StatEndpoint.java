package com.example;

import org.jboss.logging.Logger;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Path("/stats")
public class StatEndpoint {

    private static final Logger log = Logger.getLogger(StatEndpoint.class);

    private final Map<Long, Integer> requestStats = Collections.synchronizedMap(new LinkedHashMap<>());

    private Long startTime = System.currentTimeMillis() / 1000;

    public synchronized void recordRequest() {
        long secondsSinceAppStart = now();
        requestStats.merge(secondsSinceAppStart, 1, Integer::sum);
    }

    private long now() {
        return System.currentTimeMillis() / 1000 - startTime;
    }

    @DELETE
    public synchronized void reset() {
        startTime = System.currentTimeMillis() / 1000;
        requestStats.clear();
    }

    @GET
    public synchronized Map<Long, Integer> getRequestStats() {
        long currentTime = now();

        removeOldData(currentTime);

        addCurrentEntry(currentTime);

        return requestStats;
    }

    private void addCurrentEntry(long currentTime) {
        if (!requestStats.containsKey(currentTime)) {
            requestStats.put(currentTime, 0);
        }
    }

    private void removeOldData(long currentTime) {
        List<Long> toRemove = new ArrayList<>();
        for (Map.Entry<Long, Integer> statEntry : requestStats.entrySet()) {
            if (statEntry.getKey() < currentTime - 100) {
                // only entries for last 100 seconds
                toRemove.add(statEntry.getKey());
            }
        }
        toRemove.forEach(requestStats::remove);
    }
}
