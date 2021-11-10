#!/bin/bash

mvn clean package

java -Dcolor='#e0c0e0' -Dquarkus.http.port=8506 -jar target/quarkus-app/quarkus-run.jar &

java -jar target/quarkus-app/quarkus-run.jar &