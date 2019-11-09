package bookpublishingcompany.appicationlogic.publishingprocess;

import bookpublishingcompany.appicationlogic.customermanagement.Author;
import bookpublishingcompany.appicationlogic.ordermanagement.OrderManager;

import java.util.ArrayList;

public class BookManager {

    private static BookManager instance;

    private BookManager(){

    }

    public static BookManager getInstance(){
        if (instance == null) instance = new BookManager();
        return instance;
    }

    public static void createUnpublishedBook(String bookName, ArrayList<Author> authors,
                                             String dateDue, float totalAmount, float advanceAmount){
        UnpublishedBook book = new UnpublishedBook(bookName, authors);
        OrderManager orderManager = OrderManager.getInstance();
        String orderId = orderManager.createNewAuthorOrder(authors.get(0).getId(), dateDue, totalAmount, advanceAmount);
    }
}
