package bookpublishingcompany.appicationlogic.commonutilities;

import java.time.format.*;
import java.time.LocalDate;

public class CommonUtility {

    public static String getToday(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        return dtf.format(localDate);
    }
}
