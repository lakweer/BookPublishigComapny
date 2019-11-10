package bookpublishingcompany.userinterface.testingpurpose.ordermanagement;

import bookpublishingcompany.appicationlogic.ordermanagement.AuthorOrder;
import bookpublishingcompany.appicationlogic.ordermanagement.IncomePayment;
import bookpublishingcompany.appicationlogic.ordermanagement.OrderManager;

import java.sql.SQLException;
import java.util.Scanner;

public class AddIncomePaymentUI {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        OrderManager orderManager = OrderManager.getInstance();

        AuthorOrder authorOrder = orderManager.getAuthorOrderByBookId(args[0]);
        if (authorOrder != null){
            System.out.println("Add Payment to Order " + authorOrder.getId() + " ?");
            if (scanner.nextLine().equals("y")){
                System.out.print("Amount paid = ");
                float paidAmount = Float.parseFloat(scanner.nextLine());

                IncomePayment payment = new IncomePayment(authorOrder.getId(), paidAmount);
                orderManager.addIncomePaymentToOrder(authorOrder.getId(), payment);
            }
        }
    }
}
