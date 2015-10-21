# Template Generator #

We included a template generator in our toolbox to help you kick start a java project. These are generated from Freemarker template set, and can be easily extended and customize the way you like.

To see more help, use `--help` option on each command provided.

## `Template` Generator Command ##

### Generate a Spring+Freemarker ready project ###
This will create a Maven based webapp with Spring and Freemarker preconfigured. This project contains very minimal files, but have the project ready to run!

```
$ template.sh create-webapp-spring-ftl myspringweb
$ cd myspringweb && mvn jetty:run
```

Browse http://localhost:8080/myspringweb

What's next? see HowToSetupEclipseWebDevelopement

### Generate a Basic Java Servlet Web Application ###
This will create a Maven based web application using [ServletSupport](ServletSupport.md) library.

```
$ template.sh create-webapp-basic mywebapp
$ cd mywebapp && mvn jetty:run
```

Browse http://localhost:8080/mywebapp

What's next? see HowToSetupEclipseWebDevelopement

### Setup Muti Instances of Tomcat Server ###
This will setup a new instance of tomcat `CATALINA_BASE` from your installed Tomcat6 installation. The tool will setup and configure next available ports and provide a default ROOT context application so your new instance will be ready to run.

```
$ template.sh create-tomcat-instance /path/to/your/tomcat6 sandbox
$ /path/to/your/tomcat6/instances/sandbox/bin/catalina-sandbox.sh run
```
It should print the new port number it's using and you may access it in your browser for example: `http://localhost:8081`

Now you may deploy any application to the hot deploy `webapps` directory. For example:
```
$ template.sh create-webapp-basic myfirstwebapp
$ cd myfirstwebapp && mvn package
$ cp myfirstwebapp/target/*.war /path/to/your/tomcat6/instances/sandbox/webapps
```