import db.*;
import db.exception.EntityNotFoundException;
import db.exception.InvalidEntityException;
import example.*;

public class Main {
    public static void main(String[] args) throws InvalidEntityException {
        Database.registerValidator(Human.HUMAN_ENTITY_CODE, new HumanValidator());

        Human ali = new Human("Ali", -10);
        Database.add(ali);
    }
}