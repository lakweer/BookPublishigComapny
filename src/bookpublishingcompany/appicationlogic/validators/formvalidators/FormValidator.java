package bookpublishingcompany.appicationlogic.validators.formvalidators;

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

    public boolean dateValidate(String dateString){
        int[] dateParts = Arrays.stream(dateString.split("/")).mapToInt(Integer::parseInt).toArray();

        return true;
    }
}
