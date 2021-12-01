#!/bin/bash
set -euxo pipefail
IFS=$'\n\t'

docker volume create --name=grafana-volume
