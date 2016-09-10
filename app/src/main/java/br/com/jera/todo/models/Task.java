package br.com.jera.todo.models;

import java.util.Calendar;

/**
 * Created by marco on 9/10/16.
 */

public class Task {

    private String name;
    private int status;
    private Calendar createdAt;
    private Calendar updatedAt;

    public Task(String name) {
        this.name = name;
        this.status = TaskState.TODO;
    }

    public boolean isDone() {
        return status == TaskState.DONE;
    }

    public boolean isValid() {
        return name != null && !name.isEmpty();
    }

    public void beforeSave() {
        Calendar now = Calendar.getInstance();
        if(createdAt == null){
            createdAt = now;
        }
        updatedAt = now;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @TaskState.State
    public int getStatus() {
        return status;
    }

    public void setStatus(@TaskState.State int status) {
        this.status = status;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public Calendar getUpdatedAt() {
        return updatedAt;
    }
}
