package com.example;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/config")
@ApplicationScoped
public class ConfigurationEndpoint {

    private volatile Config config = new Config();

    public Config get() {
        return config;
    }

    @POST
    public void updateConfig(Config config) {
        this.config = config;
    }

    @GET
    public Config getConfig() {
        return config;
    }
}
