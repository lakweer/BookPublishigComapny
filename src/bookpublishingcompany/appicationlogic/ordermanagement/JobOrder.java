package bookpublishingcompany.appicationlogic.ordermanagement;

public class JobOrder {

    private String id, dateCreated, dateDue;
    private float totalAmount, advanceAmount;

    public JobOrder(String id, String dateCreated, String dateDue, float totalAmount, float advanceAmount) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.dateDue = dateDue;
        this.totalAmount = totalAmount;
        this.advanceAmount = advanceAmount;
    }

    public JobOrder(String dateCreated, String dateDue, float totalAmount, float advanceAmount) {
        this.dateCreated = dateCreated;
        this.dateDue = dateDue;
        this.totalAmount = totalAmount;
        this.advanceAmount = advanceAmount;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getDateDue() {
        return dateDue;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public float getAdvanceAmount() {
        return advanceAmount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
