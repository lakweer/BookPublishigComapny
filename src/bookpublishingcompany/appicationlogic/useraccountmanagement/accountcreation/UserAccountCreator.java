package bookpublishingcompany.appicationlogic.useraccountmanagement.accountcreation;

import bookpublishingcompany.appicationlogic.validators.ValidationError;
import bookpublishingcompany.appicationlogic.validators.formvalidators.FormValidator;
import bookpublishingcompany.dataexchange.testingpurpose.DataSaver;
import bookpublishingcompany.userinterface.testingpurpose.useraccountcreation.UserAccountCreationUI;

import java.util.ArrayList;
import java.util.HashMap;

/***
 * This class uses Singleton pattern in its instantiation.
 */

public class UserAccountCreator {

    private static UserAccountCreator instance;
    private DataSaver dataSaver;
    private ArrayList<ValidationError> errorList;

    private UserAccountCreator(){
        dataSaver = DataSaver.getInstance();
        errorList = new ArrayList<>();
    }

    public static UserAccountCreator getInstance() {
        if (instance == null) instance = new UserAccountCreator();
        return instance;
    }

    public boolean validateFormInput(HashMap<String, String> inputData){
        FormValidator validator = FormValidator.getInstance();
        errorList.clear();

        addError(validator.checkNotNull(inputData.get("userType")));
        addError(validator.nameValidate(inputData.get("firstName")));
        addError(validator.nameValidate(inputData.get("lastName")));
        addError(validator.dateValidate(inputData.get("dob")));
        addError(validator.phoneValidate(inputData.get("phone")));

        System.out.println(errorList.size() + "Errors:");
        for (ValidationError e : errorList){
            if (e != null) System.out.print(e.getErrorMessage());
        }

        if (errorList.size() != 0) return false;
        return true;
    }

    public void addError(ValidationError error){
        if (error != null) errorList.add(error);
    }
}
