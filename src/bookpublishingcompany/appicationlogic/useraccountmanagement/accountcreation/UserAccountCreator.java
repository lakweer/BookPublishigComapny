package bookpublishingcompany.appicationlogic.useraccountmanagement.accountcreation;

import bookpublishingcompany.dataexchange.testingpurpose.DataSaver;
import bookpublishingcompany.userinterface.testingpurpose.useraccountcreation.UserAccountCreationUI;

/***
 * This class uses Singleton pattern in its instantiation.
 */

public class UserAccountCreator {

    private static UserAccountCreator instance;
    private DataSaver dataSaver;

    private UserAccountCreator(){
        dataSaver = DataSaver.getInstance();
    }

    public static UserAccountCreator getInstance() {
        if (instance == null) instance = new UserAccountCreator();
        return instance;
    }
}
