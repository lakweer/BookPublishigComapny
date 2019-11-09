package bookpublishingcompany.appicationlogic.publishingprocess;

import bookpublishingcompany.appicationlogic.customermanagement.Author;

import java.util.ArrayList;

public class Book {
    private String id,name;
    private ArrayList<Author> authors;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }
}
