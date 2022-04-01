# cli-app

Foundation for command line interface apps in java using the build
tool gradle

## Requirements

You need JDK 11 and gradle 6.9.2 installed in your system, all later
versions and some older should work.
To make sure that you have all necessary run the following commands,
and if generates some similar output then all is ready to go.

To check your java version

```shell
java -version
```

Output:

```shell
openjdk 11.0.8 2020-07-14
OpenJDK Runtime Environment (build 11.0.8+10)
OpenJDK 64-Bit Server VM (build 11.0.8+10, mixed mode, sharing)
```

To check your gradle version

```shell
gradle -v
```

Output:

```shell
------------------------------------------------------------
Gradle 6.9.2
------------------------------------------------------------
```

Also to get the best performance of the cli you should use a Unix  
shell, to get the colors for prompt and some prints in console.

## How to add your own commands

Create a class and implement the Command interface.
| ![NewCmdUML](https://i.imgur.com/vipjhSu.png) |
|:--:|
---------------------------------------------------
Then add your command to the cli in the main method of the Main class.
| ![AddNewCmd](https://i.imgur.com/0zjRj7y.png) |
|:--:|
---------------------------------------------------

## How to use it

Once you are located in the cli-app-java folder run the following
command.

```shell
gradle --console plain run
```

| ![runningProgram](https://i.imgur.com/0bCENjY.png) |
|:--:|
---------------------------------------------------

### Jesús Israel Gutiérrez Elizalde
