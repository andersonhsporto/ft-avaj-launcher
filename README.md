# avaj-launcher

## Description

The Avaj Launcher project is an introduction to the Java world, developed as part of the curriculum at 42. This project focuses on building a simulation of an aviation scenario, where different aircraft interact with each other and with weather conditions.

# Technologies

- [Java 17](https://www.oracle.com/java/technologies/downloads/#java17) - Programming language used
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) - IDE used
- [Maven](https://maven.apache.org/) - Dependency manager

## Running the project

### Maven

To run the project using maven, run the following command in the root directory of the project:

```bash
mvn clean package
```

This will generate a `target` directory in the root directory of the project, which will contain the compiled classes and the jar file.

To run the project, run the following command in the root directory of the project:

```bash
java -jar target/avaj-launcher-1.0-SNAPSHOT.jar scenario.txt
```

### Command line

To run the project using the command line, run the following commands in the root directory of the project:

```bash
find * -name "*.java" > sources.txt

javac @sources.txt

java -cp ./src/main/java org.launcher.Avaj scenario.txt
```

## Objectives

The main objectives of the Avaj Launcher project are as follows:

- Gain familiarity with Java programming language.
- Understand object-oriented programming concepts.
- Implement a simulation using classes and interfaces.
- Handle file I/O operations.
- Generate and handle random weather conditions.
- Simulate aircraft behavior based on weather and user-defined scenarios.
- Validate the correctness of the simulation.

### Mandatory Part

The mandatory part of the project includes the following components:

- Read a scenario file containing instructions for the simulation.
- Generate weather conditions randomly.
- Create and simulate multiple aircraft based on the scenario and weather conditions.
- Write the output of the simulation to an output file.

#### Scenario File

The scenario file is a text file that contains instructions for the simulation. It defines the number of times the simulation should run and specifies the initial state of the aircraft.

#### Weather Generation

This program generate weather conditions randomly using the timestamp of the sistem. The weather can be one of the following: SUN, RAIN, FOG, or SNOW.

#### Aircrafts

This program simulate different types of aircraft, each with its own behavior and characteristics. The aircraft types include Helicopter, JetPlane, and Balloon.


### UML Diagram

Uml diagram is a visual representation of the classes and their relationships in the project.
this project's UML diagram is as follows:

![rLVTJjim5BxFKtXtHQnv0ZHHAZgOkXPHDgHDkt2JqzPRObUsqu8OFFkE7ITssgOjWfjT03dsv_FxdMDphZILkiYpw8DUG0vanQQISXqb6LMA23cFCrhmP04oLepFCz22n_T04Irlf5Yn52HvYax94shIB7ac4oqHIEQW-uMKmBL3T_f2o9Hnga6THC-xB50c4qbdEkwv3zJS9KE1wbYANqurfpcW5EWZYV_sk1oKedD0vwmAzEWwxPoWw5q](https://github.com/andersonhsporto/ft-avaj-launcher/assets/47704550/0b7306f1-027b-47c8-992c-0363b1f39943)



## Contact Information

If you have any questions, suggestions, or critiques, please contact me using [email](mailto:anderson.higo2@gmail.com)
or through [LinkedIn](https://www.linkedin.com/in/andersonhsporto/).
