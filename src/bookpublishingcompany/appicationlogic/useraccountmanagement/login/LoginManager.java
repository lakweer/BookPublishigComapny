package bookpublishingcompany.appicationlogic.useraccountmanagement.login;

import bookpublishingcompany.appicationlogic.useraccountmanagement.users.SystemUser;
import bookpublishingcompany.dataexchange.testingpurpose.PasswordProcessor;
import bookpublishingcompany.dataexchange.testingpurpose.UserManagementDB;

import java.sql.SQLException;

public class LoginManager {

    /***
     * Login Error Numbers: 0 = Login Success, 1 = Incorrect email, 2 = Incorrect password
     * @param email
     * @param password
     * @return int Login Error number
     * @throws SQLException
     */
    public Object loginUser(String email, String password) throws SQLException {
        UserManagementDB userManagementDB = new UserManagementDB();
        String[] result = userManagementDB.getPasswordAndSystemUserType(email);
        if (result != null){
            String givenPassword = PasswordProcessor.hashPassword(password);
            if (result[0].equals(givenPassword)){
                SystemUser user = null;
                switch (result[1]){
                    case "nonAdmin":
                        user = userManagementDB.getNonAdminSystemUser(email);
                        break;
                    case "admin":
                        user = userManagementDB.getAdminSystemUser(email);
                        break;
                } return user;
            } else return 2;
        } else return 1;
    }
}
