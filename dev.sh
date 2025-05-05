#!/bin/bash

# Start Vite in watch mode in the background
echo "Starting Vite in watch mode..."
cd src/main/frontend && npm run watch &
VITE_PID=$!

# Start the Java application server
echo "Starting Java application server..."
mvn jetty:run

# When the Java server stops, also stop Vite
echo "Stopping Vite..."
kill $VITE_PID
