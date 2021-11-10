#!/bin/bash

podman kill "$(podman ps | grep consul | awk '{print $1}')"