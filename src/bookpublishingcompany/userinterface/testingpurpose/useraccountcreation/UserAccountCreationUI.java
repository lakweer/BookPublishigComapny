package bookpublishingcompany.userinterface.testingpurpose.useraccountcreation;

import bookpublishingcompany.appicationlogic.useraccountmanagement.accountcreation.UserAccountCreator;
import bookpublishingcompany.userinterface.testingpurpose.UserInterface;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

public class UserAccountCreationUI extends UserInterface {

    public static void main(String[] args) throws SQLException {
        HashMap<String, String> formInput = new HashMap<>();
        UserAccountCreator creator = UserAccountCreator.getInstance();

        Scanner scanner = new Scanner(System.in);

        System.out.print("User Type: ");
        formInput.put("userType", scanner.nextLine().trim());

        System.out.print("First Name: ");
        formInput.put("firstName", scanner.nextLine().trim());

        System.out.print("Last Name: ");
        formInput.put("lastName", scanner.nextLine().trim());

        System.out.print("Residential Address: ");
        formInput.put("address", scanner.nextLine().trim());

        System.out.print("Mobile Number: ");
        formInput.put("mobileNo", scanner.nextLine().trim());

        System.out.print("Email Address: ");
        formInput.put("email", scanner.nextLine().trim());

        System.out.print("Salary (LKR): ");
        formInput.put("salary", scanner.nextLine().trim());

        System.out.print("Password: ");
        formInput.put("password", scanner.nextLine());

        System.out.print("Confirm Password: ");
        formInput.put("confirmPassword", scanner.nextLine());

        for (String i : formInput.keySet()){
            System.out.println(i + ": " + formInput.get(i));
        }

        UserAccountCreator.getInstance().createAccount(formInput);
    }
}
