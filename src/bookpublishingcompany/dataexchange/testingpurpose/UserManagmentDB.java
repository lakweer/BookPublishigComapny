package bookpublishingcompany.dataexchange.testingpurpose;

import bookpublishingcompany.appicationlogic.useraccountmanagement.users.User;

import java.sql.*;

public class UserManagmentDB {
    private Connection connection;

    public static void main(String[] args) throws SQLException {
        UserManagmentDB user = new UserManagmentDB();
//        user.createAccount(new User());
        user.isUnique("test@gmail.com");
    }

    public void createAccount(User user) throws SQLException {
        connection = Db.getConnection();
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO " +
                "9LLVL39k5B.NonAdminUser(employeeId, firstName, lastName, address, salary, mobileNo, unitId, type, email) " +
                "VALUES (UUID_TO_BIN(UUID()),?,?,?,?,?,?,?,?)");
        stmt.setString(1,user.getFirstName());
        stmt.setString(2,user.getLastName());
        stmt.setString(3,user.getAddress());
        stmt.setFloat(4,user.getSalary());
        stmt.setInt(5,user.getMobileNo());
        stmt.setInt(6,user.getUnit().getUnitId());
        stmt.setString(7, user.getType().toString());
        stmt.setString(8,user.getEmail());

    }

    public boolean isUnique(String email) throws SQLException {
        connection = Db.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT email from 9LLVL39k5B.NonAdminUser where email = ? ;");
        stmt.setString(1,email);
        ResultSet result = stmt.executeQuery();

//        if(result.getFetchSize()!=null){
            System.out.println(result.first());
//        }

        return false;
    }
}
