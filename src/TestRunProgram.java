import bookpublishingcompany.appicationlogic.commonutilities.CommonUtility;
import bookpublishingcompany.appicationlogic.useraccountmanagement.users.User;
import bookpublishingcompany.dataexchange.testingpurpose.UserManagementDB;

import java.sql.SQLException;

public class TestRunProgram {
    public static void main(String[] args) throws SQLException {
        System.out.println(CommonUtility.getToday());
        System.out.println ("Awesome");
    }
}
