package bookpublishingcompany.appicationlogic.ordermanagement;

public class AuthorOrder extends JobOrder {

    private String authorId, bookId;

    public AuthorOrder(String id, String dateCreated, String dateDue,
                       float totalAmount, float advanceAmount, String authorId, String bookId) {
        super(id, dateCreated, dateDue, totalAmount, advanceAmount);
        this.authorId = authorId;
        this.bookId = bookId;
    }

    public AuthorOrder(String dateCreated, String dateDue, float totalAmount, float advanceAmount,
                       String authorId, String bookId) {
        super(dateCreated, dateDue, totalAmount, advanceAmount);
        this.authorId = authorId;
        this.bookId = bookId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getBookId() {
        return bookId;
    }
}
