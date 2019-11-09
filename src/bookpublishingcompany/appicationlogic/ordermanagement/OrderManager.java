package bookpublishingcompany.appicationlogic.ordermanagement;

import bookpublishingcompany.appicationlogic.commonutilities.CommonUtility;
import bookpublishingcompany.dataexchange.testingpurpose.OrderManagementDB;

import java.text.DateFormat;

public class OrderManager {

    private static OrderManager instance;

    private OrderManager(){
        
    }

    public static OrderManager getInstance(){
        if (instance == null) instance = new OrderManager();
        return instance;
    }

    public String createNewAuthorOrder(String authorId, String dateDue, float totalAmount, float advanceAmount){
        AuthorOrder authorOrder = new AuthorOrder(CommonUtility.getToday(), dateDue, totalAmount,
                advanceAmount, authorId);
        OrderManagementDB db = new OrderManagementDB();
        db.saveOrder(authorOrder);
        return authorOrder.getId();
    }
}
