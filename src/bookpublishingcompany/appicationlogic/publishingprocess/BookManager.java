package bookpublishingcompany.appicationlogic.publishingprocess;

import bookpublishingcompany.appicationlogic.customermanagement.Author;
import bookpublishingcompany.appicationlogic.ordermanagement.OrderManager;
import bookpublishingcompany.dataexchange.testingpurpose.BookManagementDB;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookManager {

    private static BookManager instance;

    private BookManager(){

    }

    public static BookManager getInstance(){
        if (instance == null) instance = new BookManager();
        return instance;
    }

    public static void createUnpublishedBook(String bookName, int version, ArrayList<Author> authors,
                                             String dateDue, float totalAmount, float advanceAmount) throws SQLException {
        UnpublishedBook book = new UnpublishedBook(bookName, authors);
        if (version != 1) book.setVersion(version);
        BookManagementDB bookManagementDB = new BookManagementDB();
        UnpublishedBook savedBook = bookManagementDB.addUnpublishedBook(book);
        OrderManager orderManager = OrderManager.getInstance();
        orderManager.createNewAuthorOrder(savedBook, dateDue, totalAmount, advanceAmount);
    }
}
