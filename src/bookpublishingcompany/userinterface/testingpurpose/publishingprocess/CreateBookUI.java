package bookpublishingcompany.userinterface.testingpurpose.publishingprocess;

import bookpublishingcompany.appicationlogic.customermanagement.Author;
import bookpublishingcompany.appicationlogic.customermanagement.CustomerManager;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateBookUI {

    public static void main(String[] args) {
        System.out.println("Create New Book");

        ArrayList<Author> authors = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        //Create Book
        System.out.println("Enter Book Title");
        String bookName = scanner.nextLine();

        System.out.println("Select Author");
        Author author;

        System.out.print("Enter name: ");
        String authorName = scanner.nextLine();

        System.out.print("Enter mobile number: ");
        int authorMobileNo = Integer.parseInt(scanner.nextLine());

        if ((author = CustomerManager.getAuthor(authorName, authorMobileNo)) != null){
            System.out.println("Add " + author.getName() + " ?");

        }

    }
}
