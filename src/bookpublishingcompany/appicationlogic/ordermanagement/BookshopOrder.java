package bookpublishingcompany.appicationlogic.ordermanagement;

public class BookshopOrder extends JobOrder {
    public BookshopOrder(String id, String dateCreated, String dateDue, float totalAmount, float advanceAmount) {
        super(id, dateCreated, dateDue, totalAmount, advanceAmount);
    }

    public BookshopOrder(String dateCreated, String dateDue, float totalAmount, float advanceAmount) {
        super(dateCreated, dateDue, totalAmount, advanceAmount);
    }
}
