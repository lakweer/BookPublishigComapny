package bookpublishingcompany.dataexchange.testingpurpose;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordHashingAgent {

    private static PasswordHashingAgent instance;

    private PasswordHashingAgent(){

    }

    public static PasswordHashingAgent getInstance(){
        if (instance == null) instance = new PasswordHashingAgent();
        return instance;
    }

    /*
    code taken from https://www.baeldung.com/java-password-hashing
     */
    public static byte[] hashPassword(String passwordString) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(salt);
            return messageDigest.digest(passwordString.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return "".getBytes(StandardCharsets.UTF_8);
    }
}
