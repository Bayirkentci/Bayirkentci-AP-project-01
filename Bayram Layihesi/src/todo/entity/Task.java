package todo.entity;

import db.Entity;
import db.Trackable;

import java.util.Date;

public class Task extends Entity implements Trackable {
    public String title;
    public String description;
    public Date dueDate;
    public Status status;

    public enum Status {
        NotStarted,
        InProgress,
        Completed;
    }

    public Task(String title, String description, Date dueDate, Status status) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status.NotStarted;
    }

    @Override
    public Entity copy() {
        return null;
    }

    @Override
    public int getEntityCode() {
        return 0;
    }

    @Override
    public void setCreationDate(Date date) {

    }

    @Override
    public Date getCreationDate() {
        return null;
    }

    @Override
    public void setLastModificationDate(Date date) {

    }

    @Override
    public Date getLastModificationDate() {
        return null;
    }





}
