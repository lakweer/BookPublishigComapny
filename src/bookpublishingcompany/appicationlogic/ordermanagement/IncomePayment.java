package bookpublishingcompany.appicationlogic.ordermanagement;

public class IncomePayment {

    private String id, orderId;
    private float paidAmount;
    private PaymentType type;

    public IncomePayment(String id, String orderId, float paidAmount, PaymentType paymentType) {
        this.id = id;
        this.orderId = orderId;
        this.paidAmount = paidAmount;
        this.type = paymentType;
    }

    public IncomePayment(String orderId, float paidAmount, PaymentType paymentType) {
        this.orderId = orderId;
        this.paidAmount = paidAmount;
        this.type = paymentType;
    }

    private enum PaymentType{
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
