package todo.validator;

import db.Entity;
import db.Validator;
import db.exception.InvalidEntityException;
import todo.entity.Step;

public class StepValidator implements Validator {
    @Override
    public void validate(Entity entity) throws InvalidEntityException {
        if(!(entity instanceof Step)) {
            throw new IllegalArgumentException("Entity is not a Step");
        }
        if(((Step) entity).title.isEmpty()) {
            throw new IllegalArgumentException("Step title is empty");
        }
    }
}
