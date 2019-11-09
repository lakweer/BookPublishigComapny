package bookpublishingcompany.appicationlogic.publishingprocess;

import bookpublishingcompany.appicationlogic.customermanagement.Author;

import java.util.ArrayList;

public class Book {
    private String id,name,draft;
    private int copiesPrinted,copiesPublished;
    private BookState state = BookState.NOT_PUBLISHED;
    private float price;

    private ArrayList<Author> authors;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDraft() {
        return draft;
    }

    public int getCopiesPrinted() {
        return copiesPrinted;
    }

    public int getCopiesPublished() {
        return copiesPublished;
    }

    public BookState getState() {
        return state;
    }

    public float getPrice() {
        return price;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public enum BookState{
        PUBLISHED("published"),
        NOT_PUBLISHED("unpublished");

        private String string;
        BookState(String string){
            this.string = string;
        }

        public String getString() {
            return string;
        }
    }
}
