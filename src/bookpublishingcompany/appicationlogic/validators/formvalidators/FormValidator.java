package bookpublishingcompany.appicationlogic.validators.formvalidators;

import bookpublishingcompany.appicationlogic.validators.ValidationError;

import java.util.Arrays;

/***
 * This class uses Singleton pattern in its instantiation.
 */

public class FormValidator {

    private static FormValidator instance;

    private FormValidator(){

    }

    public static FormValidator getInstance(){
        if (instance == null) instance = new FormValidator();
        return instance;
    }

    public ValidationError checkNotNull(Object o){
        if (o != null) return null;
        return new ValidationError("Nothing Exists!");
    }

    public ValidationError dateValidate(String dateString){
        int[] dateParts = Arrays.stream(dateString.split("/")).mapToInt(Integer::parseInt).toArray();
        return null;
    }

    public ValidationError nameValidate(String nameString){
        if ((nameString != null) || !nameString.equals("")) return null;
        return new ValidationError("Name Invalid");
    }

    public ValidationError emailValidator(String emailAddress){
        if (emailAddress != null) return null;
        return new ValidationError("Email Invalid");
    }

    public ValidationError phoneValidate(String phone){
        if (phone != null) return null;
        return new ValidationError("Phone Invalid");
    }
}
