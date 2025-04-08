package db;

import db.exception.EntityNotFoundException;

import javax.swing.*;
import java.util.ArrayList;

public class Database {
    private static ArrayList<Entity> entities = new ArrayList<>();
    private static ArrayList<Integer> deletedIds = new ArrayList<>();

    public static void add(Entity e) {
        e.id = entities.size() + 1 ;
        entities.add(e);
    }
    public static Entity get(int id) {
        for (int e : deletedIds) {
            if (e == id) {
                throw new EntityNotFoundException("This entity has been deleted");
            }
        }
        for (Entity e : entities) {
            if (e.id == id) {
                return e;
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
    public static void update(Entity e) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).id == e.id) {
                entities.set(i,e);
                return;
            }
            throw new EntityNotFoundException(e.id);
        }
    }
}
