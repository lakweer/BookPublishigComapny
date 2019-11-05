package bookpublishingcompany.appicationlogic.validators;

public class ValidationError {
    private String errMsg;

    public ValidationError(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrorMessage() {
        return errMsg;
    }
}
