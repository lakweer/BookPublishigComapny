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
    package bookpublishingcompany.appicationlogic.validators.formvalidators;

import java.util.Arrays;
import java.util.regex.*;

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

    public boolean firstnameValidate(String firstnameString){ //Check the first name - Should have letters, no whitespace
        if (firstnameString!=null){
            return Pattern.matches("[A-Za-z]*\\S",firstnameString);
        }
        else{
            return false;}
    }
    public boolean surnameValidate(String surnameString){ //Check the surname- Should have letters, no whitespace
        if (surnameString!=null){
            return Pattern.matches( "[A-Za-z]*\\S",surnameString);
        }
        else{
            return false;}
    }
    public boolean emailValidate(String emailString){ //Check the email
        if (emailString!=null){
            return Pattern.matches( "^^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$" ,emailString);
        }
        else{
            return false;}
    }

    public boolean passwordValidate(String passwordString){  
        if (passwordString!=null){
            return Pattern.matches( "((?=.*\\d)(?=.*[A-Z])(?=.*[#$&@*!]).{8,20})" ,passwordString);
        }
        else{
            return false;}
    }
    /**
     * Checking the password. Constraints are, 
     * It should be between 8-20 letters 
     * Must have at least one digit, capital letter and a special character #$&@*!
     */

    public boolean dateValidate(String dateString){
        int[] dateParts = Arrays.stream(dateString.split("/")).mapToInt(Integer::parseInt).toArray();   
        ////Date should be taken from a datepicker so that unnecessary inputs won't be used
        return true;
    }
    

    public ValidationError dateValidate(String dateString){
        int[] dateParts = Arrays.stream(dateString.split("/")).mapToInt(Integer::parseInt).toArray();
        return null;
    }


    public ValidationError phoneValidate(String phone){
        if (phone != null) return null;
        return new ValidationError("Phone Invalid");
    }
}
