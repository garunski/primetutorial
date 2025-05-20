#!/bin/bash

# Start Vite in watch mode in the background
echo "Starting Vite in watch mode..."
cd src/main/frontend && npm run watch &
VITE_PID=$!

# Start the Java application server
echo "Starting Java application server..."
MAVEN_OPTS="--add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.io=ALL-UNNAMED --add-opens=java.base/java.util=ALL-UNNAMED --add-opens=java.base/java.util.concurrent=ALL-UNNAMED --add-opens=java.base/java.net=ALL-UNNAMED --add-opens=java.base/java.lang.reflect=ALL-UNNAMED --add-opens=java.desktop/java.awt.font=ALL-UNNAMED --add-opens=java.desktop/sun.awt=ALL-UNNAMED --add-opens=java.desktop/sun.java2d=ALL-UNNAMED --add-exports=java.base/sun.security.action=ALL-UNNAMED" mvn jetty:run -Pmojarra

# When the Java server stops, also stop Vite
echo "Stopping Vite..."
kill $VITE_PID
