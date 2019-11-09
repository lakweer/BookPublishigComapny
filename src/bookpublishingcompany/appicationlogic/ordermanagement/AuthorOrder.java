package bookpublishingcompany.appicationlogic.ordermanagement;

public class AuthorOrder extends JobOrder {

    private String authorId;

    public AuthorOrder(String id, String dateCreated, String dateDue,
                       float totalAmount, float advanceAmount, String authorId) {
        super(id, dateCreated, dateDue, totalAmount, advanceAmount);
        this.authorId = authorId;
    }

    public AuthorOrder(String dateCreated, String dateDue, float totalAmount, float advanceAmount,
                       String authorId) {
        super(dateCreated, dateDue, totalAmount, advanceAmount);
        this.authorId = authorId;
    }
}
