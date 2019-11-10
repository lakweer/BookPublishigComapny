package bookpublishingcompany.appicationlogic.ordermanagement;

public class IncomePayment {

    private String id, orderId;
    private float paidAmount;
    private PaymentType type = PaymentType.CASH;

    public IncomePayment(String id, String orderId, float paidAmount) {
        this.id = id;
        this.orderId = orderId;
        this.paidAmount = paidAmount;
    }

    public IncomePayment(String orderId, float paidAmount) {
        this.orderId = orderId;
        this.paidAmount = paidAmount;
    }

    public void setPaymentType (String type){}

    public PaymentType getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public float getPaidAmount() {
        return paidAmount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public enum PaymentType{
        CASH("cash"),
        CREDIT_CARD("creditCard"),
        CHEQUE("cheque");

        private String string;

        PaymentType(String string){
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }
}
