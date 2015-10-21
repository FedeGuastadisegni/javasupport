# Building javasupport Project #

  1. Install JDK1.5+
  1. Install Maven2+
  1. Install Svn Client
  1. Open your terminal and perform the following:

```
svn checkout http://javasupport.googlecode.com/svn/trunk/ javasupport-read-only
cd javasupport-read-only
mvn install
```

If you see SUCCESSFUL message, you will also have a copy of jars under `tagets` directory.

# Why Use Maven2 #
I used to use Ant tool to build all my java projects. As I progress to manage and handle more projects in my company at work, the building, release and organizing of projects just got too crazy. So I started looking into Maven2. Yes I do have many problems at first in learning it, but eventually I got it to build all my projects in a very consistent manner. I think Maven is a great tool, just like Ant, and best of all, I sometimes can make both of them work together! So if you are an Ant user, and had bad day with Maven before, don't get upset. Just look over how this javasupport uses it and you might be change your mind too.