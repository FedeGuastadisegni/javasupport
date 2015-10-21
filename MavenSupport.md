# !!! Maven Archetype Has Been Deprecated!!! #

Starting javasupport-0.0.4, maven archetypes have been removed, and been replaced by [Toolbox](Toolbox.md) Template Generator instead. Read how to use Toolbox for more information.

# !!! Maven Archetype Has Been Deprecated!!! #



The maven2 is a great tool to manage and build java projects. Here we have extended to create easy and ready to use application templates called archetypes.

# Jumpstart Your Project Using Archetypes #

Here are exmaples of how you create projects with our archetypes:

[create-archetype.sh](http://javasupport.googlecode.com/svn/trunk/maven-support/bin/create-archetype.sh) `javaapp com.mycompany myjavaapp1`

Maven2 archetype already providing a default quicstart or simplejavaapp archetype. But this template is soo simple that you will hit error as soon as you start coding! Like it default to use JDK1.4 or below, so you can't use enchanced for loop and generics! Junit is not using latest and can't use annotations etc. Our version will get you going quickly.

[create-archetype.sh](http://javasupport.googlecode.com/svn/trunk/maven-support/bin/create-archetype.sh) `webapp com.mycompany mywebapp1`

This is basic setup project for a Servlet and JSP app. Often I want just a webapp created to serve html and few simple jsp or even simple Servlet class. This will do the job.


[create-archetype.sh](http://javasupport.googlecode.com/svn/trunk/maven-support/bin/create-archetype.sh) `springwebapp com.mycompany myspringwebapp1`

SpringFramework has a MVC library stack that works really well for web development. I have successfully used SpringMVC for large and small projects. To get one going, it often requires you to digg up some templates, and xml examples to get started. Here is a templates that will get your webapp running with Simple springMVC ready.

[create-archetype.sh](http://javasupport.googlecode.com/svn/trunk/maven-support/bin/create-archetype.sh) {{{springwebapp-ftl com.mycompany myspring-ftl}}

This extends above and add sample of application that have Mysql database configured and ready to be extended! It also has all the configuration for Hibernate along with maven plugin configured to run JPA setup.

The shell script is just a wrapper calling mvn command. If you are running on Windows, then change the extension to .bat and download that instead.

The first argument to the script is your new package name, and second is your new project name.

Each project generated should hava README.txt and RELEASE.txt await you to fill them out. In README.txt I have include detail instruction on how to setup Eclipse and NetBeans IDE for each project!

NOTE: The generated project will default to a custom maven proxy repository. We encourage to create your own repository. See HowToSetupMavenInternalRepository page for details.