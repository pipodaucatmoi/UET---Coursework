#!/bin/bash

mkdir -p build
javac -d build src/main/java/*.java

if [ "$1" = "command-server" ]; then
    java -cp build CommandServer
elif [ "$1" = "command-client" ]; then
    java -cp build CommandClient
elif [ "$1" = "sensor-sender" ]; then
    java -cp build SensorSender
elif [ "$1" = "sensor-receiver" ]; then
    java -cp build SensorReceiver
else
    echo "Usage:"
    echo "./run.sh command-server"
    echo "./run.sh command-client"
    echo "./run.sh sensor-sender"
    echo "./run.sh sensor-receiver"
fi