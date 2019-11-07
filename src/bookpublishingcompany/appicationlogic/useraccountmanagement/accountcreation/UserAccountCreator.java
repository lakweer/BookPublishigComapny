package bookpublishingcompany.appicationlogic.useraccountmanagement.accountcreation;

import bookpublishingcompany.appicationlogic.validators.ValidationError;
import bookpublishingcompany.appicationlogic.validators.formvalidators.FormValidator;
import bookpublishingcompany.dataexchange.testingpurpose.DataSaver;

import java.util.ArrayList;
import java.util.HashMap;

/***
 * This class uses Singleton pattern in its instantiation.
 */

public class UserAccountCreator {

    private static UserAccountCreator instance;
    private DataSaver dataSaver;
    private ArrayList<ValidationError> errorList;
    private final String[] userTypes = {"admin", "printing", "finance", "typeSetting", "storeKeeping"};
    FormValidator formValidator;

    private UserAccountCreator() {
        formValidator = new FormValidator();
        dataSaver = DataSaver.getInstance();
        errorList = new ArrayList<>();
    }

    public static UserAccountCreator getInstance() {
        if (instance == null) instance = new UserAccountCreator();
        return instance;
    }

    private boolean validateFormInput(HashMap<String, String> inputData) {
        errorList.clear();

        for (String parameter : inputData.keySet()) {
            addError(parameter, inputData.get(parameter));
        }

        if (!inputData.get("password").equals(inputData.get("confirmPassword"))) {
            errorList.add(new ValidationError("confirmPassword", "Your passwords don't match"));
        }

        if (errorList.size() != 0) {
            for (ValidationError validationError : errorList){
                System.out.println(validationError.getErrMsg());
            }
            return false;
        }
        return true;
    }

    private void addError(String parameter, String data) {
        String errorMessage = "";

        switch (parameter) {
            case "firstName":
                if (!formValidator.nameValidate(data)) {
                    errorMessage = "Invalid First Name";
                }
                break;
            case "lastName":
                if (!formValidator.nameValidate(data)) {
                    errorMessage = "Invalid Last Name";
                }
                break;
            case "phone":
                if (data == null) {
                    errorMessage = "Please give a Phone Number";
                } else if (!formValidator.phoneValidate(data)) {
                    errorMessage = "Invalid Phone Number";
                }
                break;
            case "address":
                if (data == null) {
                    errorMessage = "Please give an address";
                }
                break;
            case "email":
                if (!formValidator.emailValidate(data)) {
                    errorMessage = "Invalid email address";
                }
                break;
            case "username":
                if (data == null) {
                    errorMessage = "Please provide a username";
                }
                break;
            case "password":
                if (!formValidator.passwordValidate(data)) {
                    errorMessage = "Please give a Password which satisfies given conditions";
                }
                break;
        }
        errorList.add(new ValidationError(parameter, errorMessage));
    }



}
