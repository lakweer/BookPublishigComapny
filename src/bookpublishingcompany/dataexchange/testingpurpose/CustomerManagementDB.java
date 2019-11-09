package bookpublishingcompany.dataexchange.testingpurpose;

import bookpublishingcompany.appicationlogic.customermanagement.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerManagementDB {

    private Connection connection;

    public boolean addAuthor(Author author) throws SQLException {
        connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO `9LLVL39k5B`.Author(name, mobileNo) VALUES (?,?);"
        );
        stmt.setString(1, author.getName());
        stmt.setInt(2, author.getMobileNo());
        return stmt.execute();
    }

    public Author getAuthor(String id) throws SQLException {
        connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(
                "SELECT  name, mobileNo FROM Author WHERE authorId=UUID_TO_BIN(?);"
        );
        stmt.setString(1,id);
        ResultSet resultSet = stmt.executeQuery();
        if(resultSet.next()){
            return new Author(
                    id,
                    resultSet.getString("name"),
                    resultSet.getInt("mobileNo"));

        }
        return null;
    }
}
