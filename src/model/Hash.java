package model;

import org.springframework.security.crypto.bcrypt.*;

public class Hash {

    

    public static String hashPass(String password){
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }

    public static boolean checkHash(String password, String hash) {
        boolean password_verified = false;

        if(null == hash || !hash.startsWith("$2a$"))
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

        password_verified = BCrypt.checkpw(password, hash);

        return(password_verified);
    }
    }



