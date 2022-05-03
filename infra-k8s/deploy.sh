#!/bin/bash

namespace=$1
echo "Deploying resources in namespace $namespace"

kubectl apply -f ../target/kubernetes/kubernetes.yml -n $namespace
kubectl apply -f deployment-v2.yaml -n $namespace
kubectl apply -f route-2-rest-service-pink.yaml -n $namespace
kubectl apply -f route-2-rest-service-blue.yaml -n $namespace