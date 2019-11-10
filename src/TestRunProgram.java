import bookpublishingcompany.appicationlogic.commonutilities.CommonUtility;
import bookpublishingcompany.appicationlogic.customermanagement.Author;
import bookpublishingcompany.appicationlogic.publishingprocess.UnpublishedBook;
import bookpublishingcompany.appicationlogic.useraccountmanagement.users.User;
import bookpublishingcompany.dataexchange.testingpurpose.BookManagementDB;
import bookpublishingcompany.dataexchange.testingpurpose.UserManagementDB;

import java.sql.SQLException;
import java.util.ArrayList;

public class TestRunProgram {
    public static void main(String[] args) throws SQLException {
        BookManagementDB bookManagementDB = new BookManagementDB();
        UnpublishedBook book = bookManagementDB.getUnpublishedBook("Madol Doova", 1);
        System.out.println(book.getId());
        ArrayList<Author> authorArrayList = bookManagementDB.getAuthorsOfBook(book);
        System.out.println(authorArrayList.get(0).getName());
    }
}
