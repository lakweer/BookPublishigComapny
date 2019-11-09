package bookpublishingcompany.appicationlogic.customermanagement;

import java.util.HashMap;

public class CustomerManager {

    private static CustomerManager instance;

    private CustomerManager(){

    }

    public static CustomerManager getInstance(){
        if (instance == null) instance = new CustomerManager();
        return instance;
    }

    public static void addNewAuthor(HashMap<String, String> authorDetails){

    }
}
