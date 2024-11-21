package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddTask {
    private List<String> all = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void getTasks() {
        boolean isRunning = true;

        System.out.println("Avalibles commands:\n- Add a task (just type it into terminal)" +
                "\n- Type 'stop' to exit\n- Type 'show' to see all tasks" +
                "\n- Type 'remove' to delete a task\n- Type 'time' to add time to task");

        while (isRunning) {
            System.out.print("Enter your command or task: ");
            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "stop":
                    isRunning = false;
                    showAllTasks();
                    break;
                case "show":
                    showAllTasks();
                    break;
                case "remove":
                    removeTask();
                    break;
                case "time":
                    dedLine();
                    break;
                default:
                    addTask(input);
            }
        }
        scanner.close();
    }

    private void addTask(String task) {
        if (!task.isEmpty()) {
            all.add(task);
            System.out.println("Task added: " + task);
        } else {
            System.out.println("Task cannot be empty!");
        }
    }

    private void showAllTasks() {
        if (all.isEmpty()) {
            System.out.println("Your task list is empty.");
        } else {
            System.out.println("Your list of tasks: ");
            for (int i = 0; i < all.size(); i++) {
                System.out.println((i + 1) + ". " + all.get(i));
            }
        }
        System.out.println("Total tasks: " + all.size());
    }

    private void removeTask() {
        if (all.isEmpty()) {
            System.out.println("No tasks to remove!");
            return;
        }
        showAllTasks();
        System.out.print("Enter the number of the task to remove: ");
        try {
            int taskIndex = Integer.parseInt(scanner.nextLine());
            if (taskIndex > 0 && taskIndex <= all.size()) {
                String removedTask = all.remove(taskIndex - 1);
                System.out.println("Succesfully removed task: " + removedTask);
            } else {
                System.out.println("Invalid task number!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number!");
        }
    }

    private void dedLine(){
        String taskWithDate = "def";
        if (all.isEmpty()) {
            System.out.println("No tasks to add date!");

        }
        showAllTasks();
        System.out.print("Enter the number of the task to add the date: ");
        int taskIndex = Integer.parseInt(scanner.nextLine());
        System.out.println("You choose this task: " + all.get(taskIndex - 1));

        System.out.print("Enter date to the task: ");
        String set_date = scanner.nextLine();

        taskWithDate = all.get(taskIndex) + " --> " + set_date;

        all.set(taskIndex - 1, taskWithDate);

    }

}
