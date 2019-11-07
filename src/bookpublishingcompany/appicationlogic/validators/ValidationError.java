package bookpublishingcompany.appicationlogic.validators;

public class ValidationError {
    private String errMsg;
    private String parameter;

    public ValidationError(String parameter, String errMsg) {
        this.errMsg = errMsg;
        this.parameter = parameter;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public String getParameter() {
        return parameter;
    }
}
