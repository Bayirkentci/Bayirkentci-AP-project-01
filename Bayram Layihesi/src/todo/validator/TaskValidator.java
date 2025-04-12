package todo.validator;

import db.Entity;
import db.Validator;
import db.exception.InvalidEntityException;
import todo.entity.Task;

public class TaskValidator implements Validator {

    @Override
    public void validate(Entity entity) throws InvalidEntityException {
        if (!(entity instanceof Task)) {
            throw new IllegalArgumentException("Entity is not a task");
        }

        if (((Task) entity).title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
    }
}
