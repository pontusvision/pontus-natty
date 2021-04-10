#!/bin/bash
TAG=${TAG:-1.13.2}
DIR="$( cd "$(dirname "$0")" ; pwd -P )"
cd $DIR/docker
docker build --rm . -t pontusvisiongdpr/pontus-natty-lib:${TAG}

docker push pontusvisiongdpr/pontus-natty-lib:${TAG}

