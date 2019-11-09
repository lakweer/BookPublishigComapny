package bookpublishingcompany.appicationlogic.publishingprocess;

import bookpublishingcompany.appicationlogic.customermanagement.Author;

import java.util.ArrayList;

public class Book {
    private String id,name;
    private ArrayList<Author> authors;

    public Book(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book(String name, ArrayList<Author> authors) {
        this.name = name;
        this.authors = authors;
    }

    public Book(String id, String name, ArrayList<Author> authors) {
        this.id = id;
        this.name = name;
        this.authors = authors;
    }

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
