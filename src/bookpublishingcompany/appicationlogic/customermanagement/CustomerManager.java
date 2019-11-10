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

    /***
     * Checks if there is an existing record for given author details. If it doesn't create a new record.
     * @param authorDetails
     * @throws SQLException
     */
    public void addNewAuthor(HashMap<String, String> authorDetails) throws SQLException {
        Author author = new Author(authorDetails.get("name"), Integer.parseInt(authorDetails.get("mobileNo")),
                authorDetails.get("email"));
        if (customerManagementDB.getAuthorByNameAndMobile(author.getName(), author.getMobileNo()) == null) {
            boolean result = customerManagementDB.addAuthor(author);
            if (!result) System.out.println("Added " + author.getName());
        } else {
            System.out.println("There is already an existing record for " + author.getName());
        }
    }

    /***
     * Searches an author by name and mobile number
     * @param authorName
     * @param mobileNo
     * @return
     * @throws SQLException
     */
    public Author getAuthor(String authorName, int mobileNo) throws SQLException {
        Author author = customerManagementDB.getAuthorByNameAndMobile(authorName, mobileNo);
        return author;
    }
}
