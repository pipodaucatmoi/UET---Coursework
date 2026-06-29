#!/bin/bash

mkdir -p build
javac -d build src/main/java/*.java

if [ "$1" = "server" ]; then
    java -cp build Server
elif [ "$1" = "client" ]; then
    java -cp build Client
else
    echo "Usage:"
    echo "./run.sh server"
    echo "./run.sh client"
fi