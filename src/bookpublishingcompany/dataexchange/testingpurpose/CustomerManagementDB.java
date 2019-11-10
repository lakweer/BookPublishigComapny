package bookpublishingcompany.dataexchange.testingpurpose;

import bookpublishingcompany.appicationlogic.customermanagement.Author;

import java.sql.*;
import java.util.ArrayList;

public class CustomerManagementDB {

    private Connection connection;

    public boolean addAuthor(Author author) throws SQLException {
        connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO `9LLVL39k5B`.Author(authorId,authorName, mobileNo,email) VALUES (UUID_TO_BIN(UUID()),?,?,?);"
        );
        stmt.setString(1, author.getName());
        stmt.setInt(2, author.getMobileNo());
        stmt.setString(3,author.getEmail());
        return stmt.execute();
    }

    public ArrayList<Author> getAllAuthors() throws SQLException {
        connection= Database.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet resultSet= stmt.executeQuery(
                "SELECT BIN_TO_UUID(authorId) authorId, authorName, mobileNo, email FROM `9LLVL39k5B`.Author;"
        );

        ArrayList<Author> authors = new ArrayList<>();
        while (resultSet.next()){
            authors.add(new Author(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getString(4)));
        }
        return authors;

    }

    public Author getAuthorById(String id) throws SQLException {
        connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(
                "SELECT  authorName, mobileNo,email FROM `9LLVL39k5B`.Author WHERE authorId = UUID_TO_BIN(?);"
        );
        stmt.setString(1,id);
        ResultSet resultSet = stmt.executeQuery();
        if(resultSet.next()){
            return new Author(
                    id,
                    resultSet.getString(1),
                    resultSet.getInt(2),
                    resultSet.getString(3)

            );

        }
        return null;
    }

    public Author getAuthorByNameAndMobile(String name, int mobileNo) throws SQLException {
        connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(
                "SELECT BIN_TO_UUID(authorId) authorId, authorName, mobileNo,email FROM `9LLVL39k5B`.Author " +
                        "WHERE authorName = ? AND mobileNo = ?;"
        );
        stmt.setString(1,name);
        stmt.setInt(2,mobileNo);

        ResultSet resultSet = stmt.executeQuery();
        if(resultSet.next()){
            return new Author(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getString(4)

            );

        }
        return null;
    }
}
