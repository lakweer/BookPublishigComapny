package bookpublishingcompany.configuration;

import java.io.*;
import java.util.HashMap;

public class Config {

    private final String CONFIG_FILE = "D:\\Disu's Collection\\MORA STUFF\\Semester 4\\Software Engineering\\" +
            "SEBookComapny\\src\\bookpublishingcompany\\configuration\\config.txt";
    private static Config instance;
    private HashMap<String, String> configInfo;

    private Config() {
        configInfo = new HashMap<>();
        getConfInfo();
    }

    public static Config getInstance() {
        if (instance == null) return new Config();
        return instance;
    }

    private void getConfInfo() {
        File file = new File(CONFIG_FILE);
        try (FileInputStream inputStream = new FileInputStream(file)) {
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] separatedPair = line.trim().split(":");
                configInfo.put(separatedPair[0].trim(), separatedPair[1].trim());
            }
            bufferedReader.close();
            streamReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, String> getConfigInfo() {
        return configInfo;
    }
}

// Creating and saving a Salt to password hash
//DO NOT EXECUTE
//        SecureRandom random = new SecureRandom();
//        byte[] saltArray = new byte[16];
//        random.nextBytes(saltArray);
//
//        String salt = new String(saltArray);
//        System.out.println(salt);
//
//        try (FileWriter fileWriter = new FileWriter("D:\\Disu's Collection\\MORA STUFF\\Semester 4\\" +
//                "Software Engineering\\SEBookComapny\\src\\bookpublishingcompany\\configuration\\config.txt", true)) {
//            PrintWriter printWriter = new PrintWriter(fileWriter);
//            printWriter.println("passSalt : "+ salt);
//            printWriter.close();
//        } catch (IOException ex){
//            System.out.println("Unable to access file");
//        }
