package bookpublishingcompany.userinterface.testingpurpose.useraccountcreation;

import bookpublishingcompany.appicationlogic.useraccountmanagement.accountcreation.UserAccountCreator;
import bookpublishingcompany.userinterface.testingpurpose.UserInterface;

import java.util.HashMap;
import java.util.Scanner;

public class UserAccountCreationUI extends UserInterface {

    public static void main(String[] args) {
        HashMap<String, String> formInput = new HashMap<>();
        UserAccountCreator creator = UserAccountCreator.getInstance();

        Scanner scanner = new Scanner(System.in);

        System.out.print("User Type: ");
        formInput.put("userType", scanner.nextLine().trim());

        System.out.print("First Name: ");
        formInput.put("firstName", scanner.nextLine().trim());

        System.out.print("Last Name: ");
        formInput.put("lastName", scanner.nextLine().trim());

        System.out.print("Date Of Birth: ");
        formInput.put("dob", scanner.nextLine().trim());

        System.out.print("Residential Address: ");
        formInput.put("address", scanner.nextLine().trim());

        System.out.print("Phone: ");
        formInput.put("phone", scanner.nextLine().trim());

        System.out.print("Email Address: ");
        formInput.put("email", scanner.nextLine().trim());

        System.out.print("Username: ");
        formInput.put("username", scanner.nextLine());

        System.out.print("Password: ");
        formInput.put("password", scanner.nextLine());

        System.out.print("Confirm Password: ");
        formInput.put("confirmPassword", scanner.nextLine());

        for (String i : formInput.keySet()){
            System.out.println(i + ": " + formInput.get(i));
        }

        System.out.println(creator.validateFormInput(formInput));
    }
}
