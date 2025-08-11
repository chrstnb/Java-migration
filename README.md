# Task Manager

This is a simple command-line task manager application written in Java.

## Description

The Task Manager allows you to add, view, and mark tasks as complete. Each task has a unique ID, a description, a due date, and a completion status.

## Prerequisites

- Java 8 or higher
- Maven

## Build

To build the project, run the following command from the root directory:

```bash
mvn package
```

This will compile the source code, run the tests, and package the application into a JAR file in the `target` directory.

## Usage

To run the application as a command-line interface (CLI), use the following command:

```bash
mvn exec:java -Dexec.mainClass="com.example.taskmanager.Main"
```

The CLI supports the following commands:
- `add <description> [<yyyy-MM-dd>]`: Adds a new task. The due date is optional.
- `list`: Displays all tasks.
- `complete <task_id>`: Marks a task as complete.
- `exit`: Exits the application.

## Running Tests

To run the tests, use the following command:

```bash
mvn test
```
