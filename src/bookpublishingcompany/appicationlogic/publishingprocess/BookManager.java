package bookpublishingcompany.appicationlogic.publishingprocess;

import bookpublishingcompany.appicationlogic.customermanagement.Author;
import bookpublishingcompany.appicationlogic.ordermanagement.OrderManager;
import bookpublishingcompany.dataexchange.testingpurpose.BookManagementDB;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookManager {

    private static BookManager instance;
    private BookManagementDB bookManagementDB;

    private BookManager(){
        bookManagementDB = new BookManagementDB();
    }

    public static BookManager getInstance(){
        if (instance == null) instance = new BookManager();
        return instance;
    }

    public boolean createUnpublishedBook(String bookName, int version, ArrayList<Author> authors,
                                         String dateDue, float totalAmount, float advanceAmount) throws SQLException {
        UnpublishedBook book = new UnpublishedBook(bookName, authors);
        if (version != 1) {
            book.setVersion(version);
        }
        UnpublishedBook savedBook = bookManagementDB.addUnpublishedBook(book);
        if (savedBook != null) {
            OrderManager orderManager = OrderManager.getInstance();
            boolean result = orderManager.createNewAuthorOrder(savedBook, dateDue, totalAmount, advanceAmount);
            return result;
        } return false;
    }

    public UnpublishedBook getUnpublishedBook(String name, int version) throws SQLException {
        return bookManagementDB.getUnpublishedBook(name, version);
    }
}
