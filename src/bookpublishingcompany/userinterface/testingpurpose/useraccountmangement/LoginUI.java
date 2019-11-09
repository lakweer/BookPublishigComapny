package bookpublishingcompany.userinterface.testingpurpose.useraccountmangement;

import bookpublishingcompany.appicationlogic.useraccountmanagement.login.LoginManager;
import bookpublishingcompany.appicationlogic.useraccountmanagement.users.SystemUser;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginUI {

    public static void main(String[] args) throws SQLException {

        String[] loginDetails = new String[2];
        LoginManager loginManager = new LoginManager();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter email: ");
        loginDetails[0] = scanner.nextLine();

        System.out.print("Enter Password: ");
        loginDetails[1] = scanner.nextLine();

        Object result = loginManager.loginUser(loginDetails[0], loginDetails[1]);

        int attempts = 1;
        while (!(result instanceof SystemUser) && attempts < 3) {
            if ((int)result == 1){
                System.out.println("Incorrect email address");
                System.out.print("Enter email: ");
                loginDetails[0] = scanner.nextLine();

                System.out.print("Enter Password: ");
                loginDetails[1] = scanner.nextLine();
            } else if ((int) result == 2){
                System.out.println("Incorrect password");
                System.out.println("Enter email: " + loginDetails[0]);

                System.out.print("Enter Password: ");
                loginDetails[1] = scanner.nextLine();
            }
            result = loginManager.loginUser(loginDetails[0], loginDetails[1]);
            attempts++;
        }

        if (result instanceof SystemUser){
            SystemUser user = (SystemUser) result;
            System.out.println("Welcome " + user.getFirstName() + " " + user.getLastName() + "!");
        } else {
            System.out.println("Login Failed!");
        }

    }
}
