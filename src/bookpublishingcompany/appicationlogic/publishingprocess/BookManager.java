package bookpublishingcompany.appicationlogic.publishingprocess;

import java.util.HashMap;

public class BookManager {

    private static BookManager instance;

    private BookManager(){

    }

    public static BookManager getInstance(){
        if (instance == null) instance = new BookManager();
        return instance;
    }

    public static void createUnpublishedBook(HashMap<String, String> bookDetails){

    }
}
