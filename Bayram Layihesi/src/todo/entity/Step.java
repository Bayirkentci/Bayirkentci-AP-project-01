package todo.entity;

import db.Entity;

public class Step extends Entity {
    String title;
    Status status;
    int taskRef;

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
