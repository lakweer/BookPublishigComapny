package bookpublishingcompany.dataexchange.testingpurpose;

import bookpublishingcompany.appicationlogic.ordermanagement.AuthorOrder;

import java.sql.*;
import java.util.Arrays;

public class OrderManagementDB {
    private Connection connection;

    public boolean saveAuthorOrder(AuthorOrder authorOrder) throws SQLException {
        connection = Database.getConnection();

        //Obtain a unique ID
        Statement stmt0 = connection.createStatement();
        ResultSet result = stmt0.executeQuery("SELECT UUID() AS UUID");
        String UUID = "";
        if (result.next()) {
            UUID = result.getString("UUID");
        }

        //Set the ID to the authorOrder
        authorOrder.setId(UUID);
        String finalUUID = authorOrder.getId();

        //Insert record into JobOrder table
        PreparedStatement stmt1 = connection.prepareStatement(
                "INSERT INTO `9LLVL39k5B`.JobOrder(dateCreated, dateDue, totalAmount, advanceAmount, orderId) " +
                        " VALUES (?,?,?,?, UUID_TO_BIN(?));"
        );
        stmt1.setString(1, authorOrder.getDateCreated());
        stmt1.setString(2, authorOrder.getDateDue());
        stmt1.setFloat(3, authorOrder.getTotalAmount());
        stmt1.setFloat(4, authorOrder.getAdvanceAmount());
        stmt1.setString(5, finalUUID);
        stmt1.execute();

        //Insert record into AuthorOrder table
        PreparedStatement stmt2 = connection.prepareStatement(
                "INSERT INTO `9LLVL39k5B`.AuthorOrder(orderId, authorId, bookId) " +
                        " VALUES (UUID_TO_BIN(?), UUID_TO_BIN(?), UUID_TO_BIN(?));"
        );
        stmt2.setString(1, finalUUID);
        stmt2.setString(2, authorOrder.getAuthorId());
        stmt2.setString(3, authorOrder.getBookId());
        return stmt2.execute();
    }

    public AuthorOrder getAuthorOrderByBookId(String bookId) throws SQLException {
        connection = Database.getConnection();

        PreparedStatement stmt = connection.prepareStatement("SELECT BIN_TO_UUID(orderId) orderId, authorId, bookId," +
                "dateCreated, dateDue, totalAmount, advanceAmount " +
                "FROM `9LLVL39k5B`.JobOrder NATURAL JOIN `9LLVL39k5B`.AuthorOrder WHERE bookId = UUID_TO_BIN(?);");
        stmt.setString(1, bookId);
        ResultSet resultSet = stmt.executeQuery();
        if (resultSet.next()){
            return new AuthorOrder(
                    resultSet.getString(1),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getFloat(6),
                    resultSet.getFloat(7),
                    resultSet.getString(2),
                    resultSet.getString(3));
        }
        return null;
    }
}
