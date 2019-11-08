package bookpublishingcompany.dataexchange.testingpurpose;

import bookpublishingcompany.configuration.Config;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordProcessor {

    private static PasswordProcessor instance;

    private PasswordProcessor(){

    }

    public static PasswordProcessor getInstance(){
        if (instance == null) instance = new PasswordProcessor();
        return instance;
    }

    /*
    code modified from https://www.baeldung.com/java-password-hashing
     */
    public static String hashPassword(String passwordString) {

        String salt = Config.getInstance().getConfigInfo().get("passSalt");

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(salt.getBytes());
            byte[] hashedPasswordBytes = messageDigest.digest(passwordString.getBytes(StandardCharsets.UTF_8));

            return new String(hashedPasswordBytes);
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return "Hashing Failed!";
    }
}
