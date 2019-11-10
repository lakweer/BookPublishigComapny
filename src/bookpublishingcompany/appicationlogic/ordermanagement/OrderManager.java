package bookpublishingcompany.appicationlogic.ordermanagement;

import bookpublishingcompany.appicationlogic.commonutilities.CommonUtility;
import bookpublishingcompany.appicationlogic.publishingprocess.Book;
import bookpublishingcompany.dataexchange.testingpurpose.FinanceManagementDB;
import bookpublishingcompany.dataexchange.testingpurpose.OrderManagementDB;

import java.sql.SQLException;
import java.text.DateFormat;

public class OrderManager {

    private static OrderManager instance;
    private OrderManagementDB orderManagementDB;

    private OrderManager(){
        orderManagementDB = new OrderManagementDB();
    }

    public static OrderManager getInstance(){
        if (instance == null) instance = new OrderManager();
        return instance;
    }

    public void createNewAuthorOrder(Book book, String dateDue, float totalAmount, float advanceAmount) throws SQLException {
        AuthorOrder authorOrder = new AuthorOrder(CommonUtility.getToday(), dateDue, totalAmount,
                advanceAmount, book.getAuthors().get(0).getId(), book.getId());
        orderManagementDB.saveAuthorOrder(authorOrder);
    }

    public AuthorOrder getAuthorOrderByBookId(String bookId) throws SQLException {
        return orderManagementDB.getAuthorOrderByBookId(bookId);
    }

    public void addIncomePaymentToOrder(String orderId, IncomePayment payment) throws SQLException {
        FinanceManagementDB financeManagementDB = new FinanceManagementDB();
        financeManagementDB.saveIncomePayment(orderId, payment);
    }
}
