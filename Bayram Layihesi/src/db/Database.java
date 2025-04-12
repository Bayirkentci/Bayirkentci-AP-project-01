package db;

import db.exception.EntityNotFoundException;
import db.exception.InvalidEntityException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Database {
    private static ArrayList<Entity> entities = new ArrayList<>();
    private static ArrayList<Integer> deletedIds = new ArrayList<>();
    private static HashMap<Integer, Validator> validators = new HashMap<>();

    public static void add(Entity e) throws InvalidEntityException {
        Validator validator = validators.get(e.getEntityCode());
        if (validator != null) {
            validator.validate(e);
        }
        if (e instanceof Trackable) {
            Date now = new Date();
            Trackable t = (Trackable) e;
            t.setCreationDate(now);
            t.setLastModificationDate(now);
        }
        e.id = entities.size() + 1;
        entities.add(e.copy());
    }

    public static Entity get(int id) {
        for (int e : deletedIds) {
            if (e == id) {
                throw new EntityNotFoundException("This entity has been deleted");
            }
        }
        for (Entity e : entities) {
            if (e.id == id) {
                return e.copy();
            }
        }
        throw new EntityNotFoundException(id);
    }
    public static void delete(int id) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).id == id) {
                entities.remove(i);
                deletedIds.add(id);
                return;
            }
        }
        throw new EntityNotFoundException(id);
    }
    public static void update(Entity e) throws InvalidEntityException {
        Validator validator = validators.get(e.getEntityCode());
        if (validator != null) {
            validator.validate(e);
        }
        if (e instanceof Trackable) {
            Date now = new Date();
            ((Trackable) e).setLastModificationDate(now);
        }
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).id == e.id) {
                entities.set(i, e.copy());
                return;
            }
        }
        throw new EntityNotFoundException(e.id);
    }
    public static void registerValidator(int entityCode, Validator validator) {
        if (validators.containsKey(entityCode)) {
            throw new IllegalArgumentException("Validator already registered for entity code: " + entityCode);
        } validators.put(entityCode, validator);
    }
    public static ArrayList<Entity> getAll(int entityCode) {
        ArrayList<Entity> list = new ArrayList<>();
        for (Entity entity : entities) {
            if (entity.getEntityCode() == entityCode)
                list.add(entity);
        }
        return list;
    }
}
