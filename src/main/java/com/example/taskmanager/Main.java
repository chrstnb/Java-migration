package com.example.taskmanager;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Task Manager CLI.");
        System.out.println("Available commands: add <description>, list, complete <task_id>, exit");

        while (true) {
            System.out.print("> ");
            String line = scanner.nextLine();
            String[] parts = line.split(" ", 2);
            String command = parts[0];

            switch (command) {
                case "add":
                    String taskId = taskManager.addTask(parts[1], new Date());
                    System.out.println("Task added with ID: " + taskId);
                case "list":
                    List<Task> tasks = taskManager.getAllTasks();
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to show.");
                    } else {
                        for (Task task : tasks) {
                            System.out.println(
                                "ID: " + task.getId() + 
                                ", Description: '" + task.getDescription() + "'" +
                                ", Completed: " + task.isCompleted()
                            );
                        }
                    }
                    break;
                case "complete":
                    if (parts.length > 1) {
                        if (taskManager.markComplete(parts[1])) {
                            System.out.println("Task marked as complete.");
                        } else {
                            System.out.println("Task not found.");
                        }
                    } else {
                        System.out.println("Please provide a task ID.");
                    }
                    break;
                case "exit":
                    System.out.println("Exiting Task Manager.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Unknown command. Available commands: add, list, complete, exit");
                    break;
            }
        }
    }
}