# cli-app
### Jesús Israel Gutiérrez Elizalde
Foundation for command line interface apps in java using the build
tool gradle
## Requirements
You need JDK 11 and gradle 6.6.1 installed in your system, all later
versions and some older should work.
To make sure that you have all necessary run the following commands,
and if generates some similar output then all is ready to go.
```
$ java -version
openjdk 11.0.8 2020-07-14
OpenJDK Runtime Environment (build 11.0.8+10)
OpenJDK 64-Bit Server VM (build 11.0.8+10, mixed mode, sharing)
```

```
$ gradle -v

------------------------------------------------------------
Gradle 6.6.1
------------------------------------------------------------

Build time:   2019-01-10 23:05:02 UTC
Revision:     3c9abb645fb83932c44e8610642393ad62116807

Kotlin DSL:   1.1.1
Kotlin:       1.3.11
Groovy:       2.5.4
Ant:          Apache Ant(TM) version 1.9.13 compiled on July 10 2018
JVM:          10.0.2 (openjdk 11.0.8)
OS:           Linux
```
Also to get the best performance of the cli you should use a Unix 
shell, to get the colors for prompt and some prints in console.

## How to add your own commands
Create a class and implement the Command interface.
| <img src="/img/newCommandinUML.png" width="70%"> |
|:--:|
---------------------------------------------------
Then add your command to the cli in the main method of the Main class.
| <img src="/img/addingNewCommand.png" width="70%"> |
|:--:|
---------------------------------------------------

## How to use it
Once you are located in the maze-generator folder run the following
command.
```
gradle --console plain run
```
| <img src="/img/exampleRun.png" width="70%"> |
|:--:|
---------------------------------------------------