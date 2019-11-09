package bookpublishingcompany.appicationlogic.publishingprocess;

import bookpublishingcompany.appicationlogic.customermanagement.Author;

import java.util.ArrayList;
import java.util.HashMap;

public class BookManager {

    private static BookManager instance;

    private BookManager(){

    }

    public static BookManager getInstance(){
        if (instance == null) instance = new BookManager();
        return instance;
    }

    public static void createUnpublishedBook(String bookName, ArrayList<Author> authors){
        UnpublishedBook book = new UnpublishedBook(bookName, authors);
    }
}
