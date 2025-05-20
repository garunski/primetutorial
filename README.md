# PrimeFaces Tutorial

![PrimeFaces icon](https://www.primefaces.org/wp-content/uploads/2016/10/prime_logo_new.png)

## Overview

This is a sample maven project that uses <strong>Latest PrimeFaces Release</strong> version. If you have a PrimeFaces issue, please download or fork this project. Then, you should change these files by yourself so that PrimeFaces Team can see your problem. Finally, you can send a link or attach the project. <strong>Please make sure that project is runnable with the command below.</strong>

You can execute the sample with <strong>mvn jetty:run</strong> command and hit <strong>http://localhost:8080/</strong> to run the page.

### Jakarta EE10 Version
***

PrimeFaces Test is setup to run with the available maven profiles: mojarra, myfaces

`mvn clean jetty:run -Pmojarra`

`mvn clean jetty:run -Pmyfaces`

### Server Port
***

By default the application runs on port 8080 but if you would like to use a different port you can pass `-Djetty.port=5000` like:

`mvn clean jetty:run -Djetty.port=5000`


### JPA Lazy Datatable
***

The branch `jpa` contains a PrimeFaces Test setup to run with JPA using the JPA LazyDatatable advanced example.

### Legacy JSF Versions
***

The branch `javax` contains a PrimeFaces Test setup to run again Jakarta EE10 profile using Jetty 9. Per default the application uses Mojarra 2.3.x.
You can also use other versions with the available maven profiles: myfaces23, myfaces23next, mojarra23

`mvn clean jetty:run -Pmyfaces23`

`mvn clean jetty:run -Pmyfaces23next`

`mvn clean jetty:run -Pmojarra23`

### Visual Studio Code Quickstart
***

See the [quickstart guide for running in Visual Studio Code](./vscode-quickstart.md) for more information.

# Quickstart guide for running in Visual Studio Code

## Prerequisites

1. [JDK installed and `JAVA_HOME` env variable set](https://github.com/redhat-developer/vscode-java/wiki/JDK-Requirements)
2. [Maven](https://maven.apache.org/install.html) installed
3. [Visual Studio Code](https://code.visualstudio.com/docs/setup/setup-overview) installed, either via installer or portable

## Setup

1. Clone or download [primefaces-test](https://github.com/primefaces/primefaces-test)
2. Start Visual Studio Code and File > Open Folder... > `primefaces-test`
3. Click Extensions (`Ctrl+Shift+X`) and search "@recommended"
4. Click Install Workspace Recommended Extensions
5. Reload Visual Studio Code as needed

## Running `primefaces-test` project

### Method #1
1. Click Explorer (`Ctrl+Shift+E`)
2. Expand Maven > primefaces-test > Plugins > jetty
3. Click Run on the "run" goal

### Method #2
1. Open Command Pallette (`Ctrl+Shift+P`)
2. Run "Tasks: Run Build Task" (`Ctrl+Shift+B` is a shortcut for this)

## Debugging

1. Set `MAVEN_OPTS` env variable to "-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8000 -Xnoagent -Djava.compiler=NONE" (this allows the debugger to attach to running server)
2. Run project (see above)
3. Click Run and Debug (`Ctrl+Shift+D`)
4. Click Start Debugging (`F5`)
## Vite Integration

This project includes Vite integration for frontend development. The Vite setup is located in the `src/main/frontend` folder.

### Development Mode

Run `./dev.sh` to start both Vite in watch mode and the Java server. This will automatically rebuild frontend assets when you make changes.

### Build for Production

Run `mvn clean package` to build both the frontend and backend. The frontend-maven-plugin will handle building the Vite assets.

### Test the Integration

Visit `/vite-demo.xhtml` to see the Vite integration in action.
