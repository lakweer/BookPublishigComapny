import bookpublishingcompany.appicationlogic.validators.formvalidators.FormValidator;

public class TestRunProgram {
    public static void main(String[] args) {
        FormValidator formValidator = FormValidator.getInstance();

        formValidator.dateValidate("01/10/2019");
    }
}
