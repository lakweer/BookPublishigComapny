package bookpublishingcompany.appicationlogic.validators;

public class Error {
    private String errMsg;

    public Error(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrorMessage() {
        return errMsg;
    }
}
