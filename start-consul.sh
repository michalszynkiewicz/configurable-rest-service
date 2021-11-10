#!/bin/bash

if netstat -nlp 2>/dev/null | grep -q 8500; then
  echo "Port 8500 in use, isn't consul started already?"
  exit 1;
fi

podman run -d -p 8500:8500 consul:1.9

echo "waiting for consul to start..."
sleep 5 # dirty wait for consul
echo "assuming consul started, registering service"

curl -v -X PUT -d @service1.json localhost:8500/v1/agent/service/register
curl -v -X PUT -d @service2.json localhost:8500/v1/agent/service/register
