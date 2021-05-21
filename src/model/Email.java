package model;

import controller.Controller;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * @author Philip Persson
 * @author Alexander Olsson
 * @version 1.0
 */

public class Email { // TODO KOMMENTERA DENNA KLASSEN!!!

    /**
     * Statsik klass för att kontrollera om användaren emailadress är gilltig.
     * @param email emailaddressen som skall kontrolleras om den är gilltig eller inte
     * @return Retunerar om det är en giltig emailaddress eller inte.
     */
    public static boolean isValidEmailAddress(String email) {
        boolean result = false;
        try {
            if (email.contains("@") && email.contains(".com") ||email.contains(".se") || email.contains(".nu")) {
                InternetAddress emailAddress = new InternetAddress(email);
                emailAddress.validate();
                result = true;
            } else {
                result = false;
            }
        } catch (AddressException exception) {
            result = false;
            exception.printStackTrace();
        }
        return result;
    }


    /**
     * Statisk metod för att skicka iväg ett mail till användaren som registrerade sig.
     * @param recipient Mottagarens email address
     * @param username Användarnamnet som skall välkomna användaren.
     */
    public static void sendMail(String recipient, String username) {
        {
            // Sender's email ID needs to be mentioned
            final String from = "supmeg25@gmail.com";
            final String pass = "FaKFiiZVZAHzNc27Ujrm4ai8p9M9sVA";
            // Recipient's email ID needs to be mentioned.
            String to = recipient;

            String host = "smtp.gmail.com";

            // Get system properties
            Properties properties = System.getProperties();
            // Setup mail server
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.user", from);
            properties.put("mail.smtp.password", pass);
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.auth", "true");

            // Get the default Session object.
            Session session = Session.getDefaultInstance(properties);

            try {

                InternetAddress emailAddr = new InternetAddress(recipient);
                emailAddr.validate();

                // Create a default MimeMessage object.
                MimeMessage message = new MimeMessage(session);

                // Set From: header field of the header.
                message.setFrom(new InternetAddress(from));

                // Set To: header field of the header.
                message.addRecipient(Message.RecipientType.TO,
                        new InternetAddress(to));

                // Set Subject: header field
                message.setSubject("Välkommen " + username + " till SupportMe!");

                // Now set the actual message
                message.setContent("<h1>Välkommen!</h1>" + "\n" + "<p>Vi på SupportMe är glada att ha dig som kund hos oss!.</p>", "text/html");

                // Send message
                Transport transport = session.getTransport("smtp");
                transport.connect(host, from, pass);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
            } catch (MessagingException exception) {
                exception.printStackTrace();
            }
        }
    }
}
