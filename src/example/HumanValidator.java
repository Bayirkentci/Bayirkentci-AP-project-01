package example;
import db.*;
import db.exception.InvalidEntityException;

public class HumanValidator implements Validator {
    @Override
    public void validate(Entity entity) throws InvalidEntityException {
        if (!(entity instanceof Human)) {
            throw new IllegalArgumentException(entity + " is not a Human");
        }
        if (((Human) entity).age < 0) {
            throw new InvalidEntityException("age cannot be negative");
        }
        if ((((Human) entity).name == null)) {
            throw new InvalidEntityException("name field cannot be null");
        }
    }
}