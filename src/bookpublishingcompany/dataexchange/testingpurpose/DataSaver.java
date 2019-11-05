package bookpublishingcompany.dataexchange.testingpurpose;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/***
 * This class uses Singleton pattern in its instantiation.
 */

public class DataSaver {

    private static DataSaver DATASAVER;

    private DataSaver() {
    }

    public static DataSaver getInstance(){
        if (DATASAVER == null) DATASAVER = new DataSaver();
        return DATASAVER;
    }

    public boolean saveData(DataItem dataItem, File fileToSave){
        try (FileWriter fileWriter = new FileWriter(fileToSave)) {
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(dataItem.getData());
            printWriter.close();
            return true;
        } catch (IOException ex){
            System.out.println("Unable to access file");
        }
        return false;
    }
}
