package bookpublishingcompany.appicationlogic.validators;

/***
 * This class uses Singleton pattern in its instantiation.
 */

public class Validator {

    private static Validator instance;

    private Validator(){

    }

    public static Validator getInstance(){
        if (instance == null) instance = new Validator();
        return instance;
    }

    public static boolean checkNotNull(Object object){
        if (object != null) return true;
        return false;
    }
}
