import bookpublishingcompany.appicationlogic.validators.formvalidators.FormValidator;
import bookpublishingcompany.dataexchange.testingpurpose.PasswordHashingAgent;

import java.util.Arrays;

public class TestRunProgram {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(PasswordHashingAgent.hashPassword("password")));
        System.out.println(Arrays.toString(PasswordHashingAgent.hashPassword("password")));
    }
}
