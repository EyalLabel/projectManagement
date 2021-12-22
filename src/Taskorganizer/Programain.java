package Taskorganizer;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;

public class Programain {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        boolean run=true;
        Task t1 = new Task(457, "do da loop", LocalDateTime.now());
        Task t2 = new Task(4589, "do da loop", LocalDateTime.now());
        t2.setDeadline(LocalDateTime.of(2021, 05, 23, 16, 38));
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(t1);
        tasks.add(t2);
        ScanThread scan = new ScanThread(tasks);
        //  scan.startMonitoringTasks();
        Thread thread = new Thread(scan);
        //   thread.start();
      //  Thread.sleep(1000 * 60 * 2);
        scan.stopMonitoringTasks();
while (run){
            System.out.println("Hello User! what would you like to do?");
            System.out.println("add a new task-------> 1");
            System.out.println("show current tasks-------> 2");
            System.out.println("do a task-------> 3");
            System.out.println("End program-------> 4");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    tasks.add(addTask());
                    break;
                case 2:
                    displayTasks(tasks);
                    break;
                case 3:
                    System.out.println("choose a task");
                    int index = input.nextInt();
                    tasks.get(index).doTask();
                    break;
                case 4:
                    run=false;
            }

        }
    }

    public static void displayTasks(ArrayList<Task> tasks) {
        for (Task task : tasks) {
            System.out.println(task.toString());
            System.out.println();
        }
    }

    public static Task addTask() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a Task Id and Task Description");
        int tempId = input.nextInt();
        input.nextLine();
        String desc = input.nextLine();
        System.out.println("Please enter a deadline: Year Month Day Hour Minute");
        int year = input.nextInt();
        int month = input.nextInt();
        int day = input.nextInt();
        int hour = input.nextInt();
        int second = input.nextInt();
        Task newTask = new Task(tempId, desc, LocalDateTime.of(year, month, day, hour, second));
        return newTask;
    }
}
