package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Path("/stats")
public class StatEndpoint {

    private List<Long> requestTimes = Collections.synchronizedList(new ArrayList<>()); // the time (millis since epoch) a request hit this service


    public void recordRequest() {
        requestTimes.add(System.currentTimeMillis());
    }

    @GET
    public Statistics getRequestTimes() {
        return new Statistics(System.currentTimeMillis(), requestTimes);
    }

    public static class Statistics {
        public long currentTime;
        public List<Long> requestTimes;

        public Statistics(long currentTime, List<Long> requestTimes) {
            this.currentTime = currentTime;
            this.requestTimes = requestTimes;
        }
    }
}
