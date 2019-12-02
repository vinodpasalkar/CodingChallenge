import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.mail.Multipart;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.InternetAddress;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.MessagingException;


class SendEmail {

    public static void main(String args[]) {

        String body;
        final String username = "test@gmail.com";
        final String password = "testpassword";
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.debug", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        //give mail content here - for now update everytime just before the run
        //we will see if any of these meaningful info can be generated using run time and attached instead or made as a part of the report
        body = "Run by : Give your name here\n" +
                "Kit combination : Give the kit details like hub - heating - additional devices if anything specific \n" +
                "\nBuild number : Give the build number that is used for running" +
                "\nAdditional information : Give any specific information if needed";
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("test@gmail.com"));
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse("test@gmail.com"));
            message.setSubject("Android Run Results - modified explicit waits");


            MimeBodyPart messageAttachmentPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();
            messageAttachmentPart = new MimeBodyPart();
            //String file = System.getProperty("user.dir")+"/target/site/serenity/serenity-summary.html";
            String file = "./target/site/serenity/serenity-summary.html";
            String fileName = "serenity-summary.html";
            DataSource source = new FileDataSource(file);
            messageAttachmentPart.setDataHandler(new DataHandler(source));
            messageAttachmentPart.setFileName(fileName);
            multipart.addBodyPart(messageAttachmentPart);

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);
            multipart.addBodyPart(messageBodyPart);


            message.setContent(multipart);

            System.out.println("Sending");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
