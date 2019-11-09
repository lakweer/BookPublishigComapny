package bookpublishingcompany.appicationlogic.customermanagement;

import bookpublishingcompany.dataexchange.testingpurpose.CustomerManagementDB;

import java.sql.SQLException;
import java.util.HashMap;

public class CustomerManager {

    private static CustomerManager instance;
    private static CustomerManagementDB customerManagementDB;

    private CustomerManager() {
        customerManagementDB = new CustomerManagementDB();
    }

    public static CustomerManager getInstance() {
        if (instance == null) instance = new CustomerManager();
        return instance;
    }

    public static void addNewAuthor(HashMap<String, String> authorDetails) throws SQLException {
        Author author = new Author(authorDetails.get("name"), Integer.parseInt(authorDetails.get("mobileNo")),
                authorDetails.get("email"));
        customerManagementDB.addAuthor(author);
    }

    public static Author getAuthor(String authorName, int mobileNo) {
        //needs to be changed. This return value is just a dummy
        return new Author("1a", "Martin", 123, "");
    }
}
