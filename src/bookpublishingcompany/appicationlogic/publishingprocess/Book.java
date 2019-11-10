package bookpublishingcompany.appicationlogic.publishingprocess;

import bookpublishingcompany.appicationlogic.customermanagement.Author;

import java.util.ArrayList;

public class Book {
    private String id,name;
    private ArrayList<Author> authors;
    private int version = 1;

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

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
