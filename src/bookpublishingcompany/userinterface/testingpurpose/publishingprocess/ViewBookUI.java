package bookpublishingcompany.userinterface.testingpurpose.publishingprocess;

import bookpublishingcompany.appicationlogic.publishingprocess.BookManager;
import bookpublishingcompany.appicationlogic.publishingprocess.UnpublishedBook;
import bookpublishingcompany.userinterface.testingpurpose.ordermanagement.AddIncomePaymentUI;

import java.sql.SQLException;
import java.util.Scanner;

public class ViewBookUI {
    public static void main(String[] args) throws SQLException {
        String[] argsPassed = new String[1];

        BookManager bookManager = BookManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Version: ");
        int version = Integer.parseInt(scanner.nextLine());

        UnpublishedBook book;

        if ((book = bookManager.getUnpublishedBook(title, version)) != null){
            System.out.println(book.getName());
            System.out.println("Go to Order?");
            if (scanner.nextLine().equals("y")){
                argsPassed[0] = book.getId();
                AddIncomePaymentUI.main(argsPassed);
            }
        }
    }
}
