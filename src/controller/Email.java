package controller;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Email {

    private String recepient;
    private String username;


    public Email(String recepient, String username) {
        this.recepient = recepient;
        this.username = username;
    }

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException exception) {
            exception.printStackTrace();
            result = false;
        }
        return result;
    }

    public static void sendMail(String recepient, String username) {
        {
            // Sender's email ID needs to be mentioned
            final String from = "supmeg25@gmail.com";
            final String pass = "supportme25";
            // Recipient's email ID needs to be mentioned.
            String to = recepient;

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

                InternetAddress emailAddr = new InternetAddress(recepient);
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
                System.out.println("Sent message successfully....");
            } catch (MessagingException mex) {
                mex.printStackTrace();
            }
        }
    }
}
