package bookpublishingcompany.appicationlogic.useraccountmanagement.accountcreation;

import bookpublishingcompany.appicationlogic.useraccountmanagement.users.SystemUser;
import bookpublishingcompany.appicationlogic.useraccountmanagement.users.User;
import bookpublishingcompany.appicationlogic.validators.ValidationError;
import bookpublishingcompany.appicationlogic.validators.formvalidators.FormValidator;
import bookpublishingcompany.dataexchange.testingpurpose.DataSaver;
import bookpublishingcompany.dataexchange.testingpurpose.PasswordHashingAgent;
import bookpublishingcompany.dataexchange.testingpurpose.UserManagementDB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/***
 * This class uses Singleton pattern in its instantiation.
 */

public class UserAccountCreator {

    private static UserAccountCreator instance;
    private DataSaver dataSaver;
    private ArrayList<ValidationError> errorList;
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

    private boolean validateFormInput(HashMap<String, String> inputData) throws SQLException {
        errorList.clear();

        for (String parameter : inputData.keySet()) {
            addError(parameter, inputData.get(parameter));
        }

        if (!inputData.get("password").equals(inputData.get("confirmPassword"))) {
            errorList.add(new ValidationError("confirmPassword", "Your passwords don't match"));
        }

        System.out.println(errorList.size());

        if (errorList.size() != 0) {
            for (ValidationError validationError : errorList){
                System.out.println(validationError.getErrMsg());
            }
            return false;
        }
        return true;
    }

    private void addError(String parameter, String data) throws SQLException {
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
            case "mobileNo":
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
                } else {
                    UserManagementDB userManagementDB = new UserManagementDB();
                    if (!userManagementDB.isEmailUnique(data)){
                        errorMessage = "Email is already being used. Please use another account.";
                    }
                }
                break;
            case "password":
                if (!formValidator.passwordValidate(data)) {
                    errorMessage = "Please give a Password which satisfies given conditions";
                }
                break;
            case "salary":
                if (!formValidator.isPositive(Float.parseFloat(data))){
                    errorMessage = "Invalid value for salary";
                }
        }
        if (!errorMessage.equals("")) errorList.add(new ValidationError(parameter, errorMessage));
    }

    public void createAccount(HashMap<String, String> inputData) throws SQLException {
        if (validateFormInput(inputData)){
            System.out.println("Form Validation Successful");
            String hashedPassword = PasswordHashingAgent.hashPassword(inputData.get("password"));

            SystemUser userNew = new SystemUser(inputData.get("firstName"), inputData.get("lastName"), inputData.get("address"),
                    Float.parseFloat(inputData.get("salary")),
                    Integer.parseInt(inputData.get("mobileNo")),
                    User.UserType.getType(inputData.get("userType")), inputData.get("email"));

            System.out.println(Arrays.toString(userNew.getAllDetails()));

            UserManagementDB userManagementDB = new UserManagementDB();
            userManagementDB.createSystemUser(userNew, hashedPassword);
        }
    }
}
