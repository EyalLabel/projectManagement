package Taskorganizer;

import java.time.LocalDateTime;
import java.util.List;

public class ScanThread implements Runnable {
    private List<Task> tasks;
    private boolean monitoringOn = false;

    public ScanThread(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void startMonitoringTasks() {
        System.out.println("Starting monitoring");
        this.monitoringOn = true;
    }

    public void stopMonitoringTasks() {
        System.out.println("Stopping monitor");
        this.monitoringOn = false;
    }

    @Override
    public void run() {
        while (monitoringOn) {
            checkDeadline();
            try {
                Thread.sleep(1000 * 60);
            } catch (InterruptedException e) {
                System.out.println("Interrupted monitor");
            }
        }

    }

    public void checkDeadline() {
        LocalDateTime now = LocalDateTime.now();
        for (Task item : tasks) {
            if (item.getDeadline().isBefore(now) && !item.isAlertPopped()) {
                System.out.println("DEADLINE REACHED " + item);
                item.setAlertPopped(true);
            }
        }
    }

}
