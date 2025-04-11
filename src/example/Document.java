package example;

import db.Entity;
import db.Trackable;

import java.util.Date;

public class Document extends Entity implements Trackable {
    public String content;
    public static final int Document_ENTITY_CODE = 10;

    public Document(String content) {
        this.content = content;
    }

    @Override
    public Entity copy() {
        Document documentCopy = new Document(content);
        documentCopy.creationDate = creationDate;
        documentCopy.lastModificationDate = lastModificationDate;
        documentCopy.id = id;

        return documentCopy;
    }

    @Override
    public int getEntityCode() {
        return Document_ENTITY_CODE;
    }

    @Override
    public void setCreationDate(Date date) {
        creationDate = date;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public void setLastModificationDate(Date date) {
        lastModificationDate = date;
    }

    @Override
    public Date getLastModificationDate() {
        return lastModificationDate;
    }
}
