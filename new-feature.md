# New Feature Proposal: Task Priorities

## 1. Feature Overview

This proposal outlines a new feature for the Task Manager application: **Task Priorities**.

The core idea is to allow users to assign a priority level (e.g., HIGH, MEDIUM, LOW) to each task. This helps users organize their to-do list more effectively, focusing on what's most important first. When tasks are listed, they can be sorted by this priority level.

This feature is designed to be simple to understand and use, making it an ideal candidate for a UX study to observe how users interact with prioritization in a command-line environment.

## 2. User Interaction

### Adding a Task with Priority

Users can specify a priority when adding a new task. If no priority is given, it will default to `MEDIUM`.

**Command:**
```bash
java -jar taskmanager.jar addTask "Deploy the new feature" --priority HIGH
java -jar taskmanager.jar addTask "Write documentation" # Defaults to MEDIUM
```

### Listing Tasks

The default `listTasks` command will be updated to display the priority level alongside the task details.

**Command:**
```bash
java -jar taskmanager.jar listTasks
```

**Output:**
```
ID: 1, Task: "Deploy the new feature", Status: PENDING, Priority: HIGH
ID: 2, Task: "Write documentation", Status: PENDING, Priority: MEDIUM
```

### Listing Tasks Sorted by Priority

A new command will be introduced to list all tasks sorted from highest to lowest priority.

**Command:**
```bash
java -jar taskmanager.jar listByPriority
```

**Output:**
```
ID: 1, Task: "Deploy the new feature", Status: PENDING, Priority: HIGH
ID: 2, Task: "Write documentation", Status: PENDING, Priority: MEDIUM
```

## 3. Implementation Sketch

1.  **`Task.java`:**
    *   Add a `Priority` enum: `enum Priority { HIGH, MEDIUM, LOW }`.
    *   Add a `private Priority priority;` field to the `Task` class.
    *   Update the constructor to accept a priority, defaulting to `MEDIUM`.
    *   Add a `getPriority()` getter.

2.  **`TaskManager.java`:**
    *   Update the `addTask(String description)` method to parse an optional priority flag.
    *   Modify the `listTasks()` method to include the priority in the output string.
    *   Implement a new `listByPriority()` method that retrieves tasks and sorts them based on the `Priority` enum's ordinal value.

3.  **`TaskManagerTest.java`:**
    *   Add tests to verify that a task is created with the correct default priority.
    *   Add tests to verify that a task is created with a specified priority.
    *   Add tests for the `listByPriority()` method to ensure the sorting is correct.
