package db.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException() {
        super("Cannot find entity");
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(int id) {
        super("Can't find the entity with id number: " + id);
    }
}
