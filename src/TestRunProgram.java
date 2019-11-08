import bookpublishingcompany.appicationlogic.useraccountmanagement.users.User;
import bookpublishingcompany.appicationlogic.validators.formvalidators.FormValidator;
import bookpublishingcompany.configuration.Config;
import bookpublishingcompany.dataexchange.testingpurpose.PasswordHashingAgent;
import bookpublishingcompany.dataexchange.testingpurpose.UserManagementDB;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.Arrays;

public class TestRunProgram {
    public static void main(String[] args) throws SQLException {
        UserManagementDB db = new UserManagementDB();
        //System.out.println(db.getNonAdminSystemUser("disurawaru.17@cse.mrt.ac.lk").getFirstName());
        //System.out.println(db.isEmailUnique("disurawaru.17@cse.mrt.ac.lk"));
    }
}
