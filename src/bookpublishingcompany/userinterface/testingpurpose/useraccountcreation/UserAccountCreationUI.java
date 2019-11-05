package bookpublishingcompany.userinterface.testingpurpose.useraccountcreation;

import bookpublishingcompany.userinterface.testingpurpose.UserInterface;

import java.util.HashMap;
import java.util.Scanner;

public class UserAccountCreationUI extends UserInterface {

    public static void main(String[] args) {
        HashMap<String, String> formInput = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("First Name: ");
        formInput.put("firstName", scanner.nextLine());

        System.out.print("Last Name: ");
        formInput.put("lastName", scanner.nextLine());

    }
}
