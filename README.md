# configurable-rest-service

An example back-end service used in [Quarkus Insights #70](https://www.youtube.com/watch?v=l3mLKU3wR2A).


## Running
To start the service, build it and run the created jar:
```shell
./mvnw clean package
java -jar target/quarkus-app/quarkus-run.jar
```

## Usage
This will expose an endpoint http://localhost:8406/test. 
If you go to http://localhost:8406 in your browser, you'll see a web page that lets you control the response delay 
of the endpoint and if it should return an erroneous response. You will also see a chart of the amount of requests consumed by the service.

You can use `color` system property to control the background color of the page, which is useful for demos.

## Utilities
The root directory of the project contains a few utility scripts:
- `start-two.sh` starts two instances of the service, one blue and one pink, on ports 8406 and 8506, `kill-started.sh` kills the services if executed in the same terminal
- `start-consul.sh`/`stop-consul.sh` starts/stops Consul in a podman container, and registers the two services as `my-service`. Replace `podman` with `docker` in the scripts if you prefer it
- `register-custom.sh` registers the two services in a [simple service discovery server](https://github.com/michalszynkiewicz/simple-service-discovery-server)
