package todo.entity;

import db.Entity;

public class Step extends Entity {
    public String title;
    public Status status;
    public int taskRef;

    public Step(String title, Status status, int taskRef) {
        this.title = title;
        this.status = status;
        this.taskRef = taskRef;
    }

    @Override
    public Entity copy() {
        return null;
    }

    @Override
    public int getEntityCode() {
        return 0;
    }

    enum Status {
        NotStarted,
        Completed;
    }
}
