import bookpublishingcompany.appicationlogic.commonutilities.CommonUtility;
import bookpublishingcompany.appicationlogic.customermanagement.Author;
import bookpublishingcompany.appicationlogic.ordermanagement.OrderManager;
import bookpublishingcompany.appicationlogic.publishingprocess.UnpublishedBook;
import bookpublishingcompany.appicationlogic.useraccountmanagement.users.User;
import bookpublishingcompany.dataexchange.testingpurpose.BookManagementDB;
import bookpublishingcompany.dataexchange.testingpurpose.UserManagementDB;
import bookpublishingcompany.userinterface.testingpurpose.publishingprocess.CreateBookUI;

import java.sql.SQLException;
import java.util.ArrayList;

public class TestRunProgram {
    public static void main(String[] args) throws SQLException {
        BookManagementDB bookManagementDB = new BookManagementDB();
        UnpublishedBook book = bookManagementDB.getUnpublishedBook("Madol Doova", 1);
        OrderManager orderManager = OrderManager.getInstance();
        System.out.println(orderManager.getAuthorOrderByBookId(book.getId()).getDateCreated());

    }
}
