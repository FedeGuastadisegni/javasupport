# Static Methods Helper #

We have great library from Apache Commons with comons-lang, commons-io, and commons-net. Matter of matter this project will include these as dependencies and reuse what's available.

But there is missing few methods I like to do things quickly. For examples creating a ArrayList, Date, or write to a file, read from a file etcs. You will will these small little helper in javasupport.jdk.lang.ShortMethodsHelper.

Examples
```
List<String> name = mklist("john", "marry", "joe");
List<Integer> nums = mklist(1,2,3,4,5);
Date dob = mkdate("1970/1/1");
List<Integer> odds = slice(nums, 0,-1,2); //index zero until end, with step of two.

writeText("/tmp/test.txt", "HelloWorld");
String greeting = readText("/tmp/test.txt");

String output = exec("find" "/tmp", "-name ".txt");
```


# The `CliApplication` Helper class #

Java application is pretty fast, fast enough that I like to write commandline utilities to replace/add to my Unix commands. Here I have a base class that let you extends and write CLI quickly.

An example you can use:
```
public class Hello extends CliApplication {
        void main(String[] args) { 
            args = parseOptions(args);
            if (hasOpt("help")) {
                exit("java Hello [options] arguments...");
            }        
            if (hasOpt("file")) {
                println("We will write to file " + getOpt("file", "test.txt"));
            } 
            if (hasOpt("maxThread")) {
                println("We will set limit of " + getIntOpt("maxThread", 3) + " threads per run");
            }
            println("Hello, you have " + args.length + " argument(s) after options parsing.");
        }
    }
```

Yes, there is commons-cli library from apache, but it's quiet hard to use and too much Classes to setup to get something simple going.