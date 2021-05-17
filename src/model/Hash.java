package model;

import org.springframework.security.crypto.bcrypt.*;

/**
 * @author Philip Persson
 * @version 1.0
 */
public class Hash {


    /**
     * Statisk metod för att generera ett hashat lösenord som gör det svårare att läsa av.
     * @param password Lösenordet som användaren matar in
     * @return Retunerar ett hashat lösenord
     */
    public static String hashPass(String password){
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }


    /**
     * Statsik metod för att kontrollera inmatade lösenordet mastchar det hashade lösenordet.
     * @param password Användarens lösenord som hen matar in
     * @param hash Det hashade lösenordet från databasen
     * @return Retunerar vidare lösenorden matchar eller inte
     */
    public static boolean checkHash(String password, String hash) {
        boolean password_verified = false;

        if(null == hash || !hash.startsWith("$2a$"))
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

        password_verified = BCrypt.checkpw(password, hash);

        return(password_verified);
    }

}

