#!/bin/bash

curl -v -H "Content-Type: application/json" -X POST -d @service1-custom.json localhost:9090/services
curl -v -H "Content-Type: application/json" -X POST -d @service2-custom.json localhost:9090/services