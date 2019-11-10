package bookpublishingcompany.userinterface.testingpurpose.publishingprocess;

import bookpublishingcompany.appicationlogic.customermanagement.Author;
import bookpublishingcompany.appicationlogic.customermanagement.Customer;
import bookpublishingcompany.appicationlogic.customermanagement.CustomerManager;
import bookpublishingcompany.appicationlogic.publishingprocess.BookManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateBookUI {

    public static void main(String[] args) throws SQLException {
        System.out.println("Create New Book");
        CustomerManager customerManager = CustomerManager.getInstance();

        ArrayList<Author> authors = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        //Create Book
        System.out.print("Enter Book Title: ");
        String bookName = scanner.nextLine();

        System.out.print("Enter Version: ");
        int version = Integer.parseInt(scanner.nextLine());

        System.out.println("Select Author");
        Author author;

        System.out.print("Enter name: ");
        String authorName = scanner.nextLine();

        System.out.print("Enter mobile number: ");
        int authorMobileNo = Integer.parseInt(scanner.nextLine());

        if ((author = customerManager.getAuthor(authorName, authorMobileNo)) != null){
            authors.add(author);
            System.out.println(author.getName() + " added");
        }

        //Add more authors if required
        //Display to check if correct, allow to change if needed

        System.out.println("Create New Order");

        System.out.print("Due date: ");
        String dateDue = scanner.nextLine();

        System.out.println("Total Amount (LKR): ");
        float totalAmount = Float.parseFloat(scanner.nextLine());

        System.out.println("Advance Amount (LKR): ");
        float advanceAmount = Float.parseFloat(scanner.nextLine());

        BookManager.createUnpublishedBook(bookName,version, authors, dateDue, totalAmount, advanceAmount);

    }
}
