package com.example;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
@ApplicationScoped
public class SaulGoodmanEndpoint {

    @Inject
    ConfigurationEndpoint configStorage;

    @Inject
    StatEndpoint stats;

    @GET
    public Response test() throws InterruptedException {
        stats.recordRequest();
        Config config = configStorage.get();
        long delay = config.delay;
        if (delay != 0) {
            Thread.sleep(delay);
        }

        if (config.forceErrors) {
            return Response.serverError().build();
        } else {
            return Response.ok().entity("It's all good, man!").build();
        }
    }
}