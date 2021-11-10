package com.example;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/config")
@ApplicationScoped
public class ConfigurationEndpoint {

    private volatile Config config = new Config();

    @PostConstruct
    public void init() {
        config.color = System.getProperty("color", "skyblue");
    }

    public Config get() {
        return config;
    }

    @POST
    public void updateConfig(Config config) {
        config.color = this.config.color;
        this.config = config;
    }

    @GET
    public Config getConfig() {
        return config;
    }
}
