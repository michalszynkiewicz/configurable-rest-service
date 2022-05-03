#!/bin/bash

namespace=$1
echo "Removing resources from namespace $namespace"

kubectl delete -f ../target/kubernetes/kubernetes.yml -n $namespace
kubectl delete -f deployment-v2.yaml -n $namespace
kubectl delete -f route-2-rest-service-pink.yaml -n $namespace
kubectl delete -f route-2-rest-service-blue.yaml -n $namespace