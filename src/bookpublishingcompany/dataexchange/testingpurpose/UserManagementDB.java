package bookpublishingcompany.dataexchange.testingpurpose;

import bookpublishingcompany.appicationlogic.useraccountmanagement.users.NonSystemUser;
import bookpublishingcompany.appicationlogic.useraccountmanagement.users.SystemUser;
import bookpublishingcompany.appicationlogic.useraccountmanagement.users.User;

import java.sql.*;
import java.util.ArrayList;

public class UserManagementDB {
    private Connection connection;

    public void createSystemUser(SystemUser user, String password) throws SQLException {
        connection = Database.getConnection();

        //Saving the credentials of user account in SystemUserCredential table
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO " +
                "9LLVL39k5B.SystemUserCredential(employeeId, email, password, systemUserType) " +
                "VALUES (UUID_TO_BIN(UUID()),?,?,?)");
        stmt.setString(1, user.getEmail());
        stmt.setString(2, password);
        stmt.setString(3, user.getSystemUserType());
        stmt.execute();

        //Retrieving the ID of the saved user
        PreparedStatement stmt1 = connection.prepareStatement(
                "SELECT BIN_TO_UUID(employeeId) employeeId FROM 9LLVL39k5B.SystemUserCredential WHERE email=?"
        );
        stmt1.setString(1, user.getEmail());
        ResultSet result1 = stmt1.executeQuery();
        String employeeId = null;
        while (result1.next()) {
            employeeId = result1.getString(1);
        }

        if (employeeId == null) return; //Failed to create account

        if (user.getType() instanceof User.UserType) {
            //Saving user details in NonAdminUser table
            PreparedStatement stmt2 = connection.prepareStatement("INSERT INTO " +
                    "9LLVL39k5B.NonAdminUser(employeeId, firstName, lastName, address, salary, mobileNo, unitId, type, email) " +
                    "VALUES (UUID_TO_BIN(?),?,?,?,?,?,?,?,?)");
            stmt2.setString(1, employeeId);
            stmt2.setString(2, user.getFirstName());
            stmt2.setString(3, user.getLastName());
            stmt2.setString(4, user.getAddress());
            stmt2.setFloat(5, user.getSalary());
            stmt2.setInt(6, user.getMobileNo());
            stmt2.setInt(7, user.getType().getUnitId());
            stmt2.setString(8, user.getType().toString());
            stmt2.setString(9, user.getEmail());
            stmt2.execute();
        } else {
            //Saving user details in AdminUser table
            PreparedStatement stmt2 = connection.prepareStatement("INSERT INTO " +
                    "9LLVL39k5B.AdminUser(employeeId, firstName, lastName, address, salary, mobileNo, unitId, email) " +
                    "VALUES (UUID_TO_BIN(?),?,?,?,?,?,?,?)");
            stmt2.setString(1, employeeId);
            stmt2.setString(2, user.getFirstName());
            stmt2.setString(3, user.getLastName());
            stmt2.setString(4, user.getAddress());
            stmt2.setFloat(5, user.getSalary());
            stmt2.setInt(6, user.getMobileNo());
            stmt2.setInt(7, SystemUser.ADMIN_USER_UNIT);
            stmt2.setString(8, user.getEmail());
            stmt2.execute();
        }

    }

    /***
     * @param email
     * @return true if no match found, false otherwise
     * @throws SQLException
     */
    public boolean isEmailUnique(String email) throws SQLException {
        connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT email from 9LLVL39k5B.NonAdminUser where email = ? ;");
        stmt.setString(1, email);
        ResultSet result = stmt.executeQuery();
        return !result.first();
    }

    /***
     * @param email
     * @return an Array with elements password at index 0, and systemUserType at index 1
     * @throws SQLException
     */
    public String[] getPasswordAndSystemUserType(String email) throws SQLException {
        connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(
                "SELECT BIN_TO_UUID(employeeId) employeeId, password, systemUserType" +
                        " FROM 9LLVL39k5B.SystemUserCredential WHERE email=?"
        );
        stmt.setString(1, email);
        ResultSet result1 = stmt.executeQuery();
        String employeeId = null;
        if (result1.next()) {
            employeeId = result1.getString(1);
            String[] passType = {result1.getString(2), result1.getString(3)};
            return passType;
        }
        return null;
    }

    public SystemUser getNonAdminSystemUser(String email) throws SQLException {
        connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(
                "SELECT BIN_TO_UUID(employeeId) employeeId,email,firstName,lastName,address,mobileNo,salary,type,unitId " +
                        "FROM 9LLVL39k5B.SystemUserCredential NATURAL JOIN 9LLVL39k5B.NonAdminUser WHERE email = ?;"
        );

        return getSystemUser(email, stmt);
    }

    public SystemUser getAdminSystemUser(String email) throws SQLException {
        connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(
                "SELECT BIN_TO_UUID(employeeId) employeeId,email,firstName,lastName,address,mobileNo,salary,unitId " +
                        "FROM 9LLVL39k5B.SystemUserCredential NATURAL JOIN 9LLVL39k5B.AdminUser WHERE email = ?;"
        );

        return getSystemUser(email, stmt);
    }

    private SystemUser getSystemUser(String email, PreparedStatement stmt) throws SQLException {
        stmt.setString(1, email);
        ResultSet result = stmt.executeQuery();

        if (result.next()) {
            return new SystemUser(
                    result.getString(1),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getFloat(7),
                    result.getInt(6),
                    User.UserType.getType(result.getString(8)),
                    result.getString(2)
            );
        }
        return null;
    }

    public boolean createNonSystemUser(NonSystemUser user) throws SQLException {
        connection = Database.getConnection();

        PreparedStatement stmt = connection.prepareStatement("INSERT INTO " +
                "9LLVL39k5B.NonAdminUser(employeeId, firstName, lastName, address, salary, mobileNo, unitId) " +
                "VALUES (UUID_TO_BIN(UUID()),?,?,?,?,?,?)");
        stmt.setString(1, user.getFirstName());
        stmt.setString(2, user.getLastName());
        stmt.setString(3, user.getAddress());
        stmt.setFloat(4, user.getSalary());
        stmt.setInt(5, user.getMobileNo());
        stmt.setInt(6, user.getType().getUnitId());
//        stmt2.setString(7, user.getType().toString());
        return stmt.execute();
    }

    public boolean removeNonSystemUSer(NonSystemUser user) throws SQLException {
        connection = Database.getConnection();

        PreparedStatement stmt = connection.prepareStatement("DELETE FROM `9LLVL39k5B`.NonSystemUser WHERE employeeId = ?");
        stmt.setString(1, user.getId());

        return stmt.execute();
    }

    public ArrayList<NonSystemUser> getAllNonSystemUsers() throws SQLException {
        connection = Database.getConnection();

        ArrayList<NonSystemUser> allNonSystemUsers = new ArrayList<>();
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM NonSystemUser");
        while (resultSet.next()) {
            allNonSystemUsers.add(new NonSystemUser(
                    resultSet.getString(1),
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getFloat(6),
                    resultSet.getInt(7),
                    User.UserType.getType(resultSet.getString(8))
            ));
        }
        return allNonSystemUsers;
    }

}
