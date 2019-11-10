package bookpublishingcompany.appicationlogic.ordermanagement;

import bookpublishingcompany.appicationlogic.commonutilities.CommonUtility;
import bookpublishingcompany.appicationlogic.publishingprocess.Book;
import bookpublishingcompany.dataexchange.testingpurpose.OrderManagementDB;

import java.sql.SQLException;
import java.text.DateFormat;

public class OrderManager {

    private static OrderManager instance;

    private OrderManager(){
        
    }

    public static OrderManager getInstance(){
        if (instance == null) instance = new OrderManager();
        return instance;
    }

    public void createNewAuthorOrder(Book book, String dateDue, float totalAmount, float advanceAmount) throws SQLException {
        AuthorOrder authorOrder = new AuthorOrder(CommonUtility.getToday(), dateDue, totalAmount,
                advanceAmount, book.getAuthors().get(0).getId(), book.getId());
        OrderManagementDB db = new OrderManagementDB();
        db.saveOrder(authorOrder);
    }
}
