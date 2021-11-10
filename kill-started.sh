#!/bin/bash

# shellcheck disable=SC2046
kill $(ps -f | grep quarkus-run | grep -v grep | awk '{print $2}')