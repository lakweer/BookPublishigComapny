package bookpublishingcompany.dataexchange.testingpurpose;

import bookpublishingcompany.appicationlogic.ordermanagement.IncomePayment;

import java.sql.*;

public class FinanceManagementDB {

    private Connection connection;

    public void saveIncomePayment(String orderId, IncomePayment payment) throws SQLException {
        connection = Database.getConnection();
        //Obtain a unique ID
        Statement stmt0 = connection.createStatement();
        ResultSet result = stmt0.executeQuery("SELECT UUID() AS UUID");
        String UUID = "";
        if (result.next()) {
            UUID = result.getString("UUID");
        }

        //Set the ID to the payment
        String finalUUID = UUID;
        payment.setId(finalUUID);

        PreparedStatement stmt1 = connection.prepareStatement(
                "INSERT INTO `9LLVL39k5B`.IncomePayment (orderId, paymentType, paidAmount, paymentId) " +
                        "VALUES (UUID_TO_BIN(?), ?, ?, UUID_TO_BIN(?));");
        stmt1.setString(1, orderId);
        stmt1.setString(2, payment.getType().toString());
        stmt1.setFloat(3, payment.getPaidAmount());
        stmt1.setString(4,finalUUID);
        stmt1.execute();
    }
}
