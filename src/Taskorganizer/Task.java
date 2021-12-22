package Taskorganizer;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Objects;

public class Task implements Comparable<Task> {
    private int id;
    private String description;
    private Boolean done = false;
    protected LocalDateTime deadline;
    private boolean alertPopped = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public boolean isAlertPopped() {
        return alertPopped;
    }

    public void setAlertPopped(boolean alertPopped) {
        this.alertPopped = alertPopped;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return id == task.id && alertPopped == task.alertPopped && Objects.equals(description, task.description) && Objects.equals(done, task.done) && Objects.equals(deadline, task.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, done, deadline, alertPopped);
    }

    public void doTask() {
        System.out.println("doing task- " + this.description);
        done = true;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", done=" + done +
                ", deadline=" + deadline +
                ", alertPopped=" + alertPopped +
                '}';
    }


    public Task(int id, String description, LocalDateTime deadline) {
        this.id = id;
        this.description = description;
        this.deadline = deadline;
    }


    @Override
    public int compareTo(Task o) {
        if (equals(o)) {
            return 0;
        }
        //equals compare if the object date is before, same , after
        //                                       -1      0      1
        return deadline.compareTo(o.deadline);
    }
}
