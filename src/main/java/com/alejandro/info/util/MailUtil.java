package com.alejandro.info.util;

import com.alejandro.info.model.MailModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Set;

public class MailUtil {

    private final static Logger logger = LoggerFactory.getLogger(MailUtil.class);

    private static final String PROTOCOL = "smtp";

    private static final String HOST_PROP = "mail.smtp.host";
    private static final String USER_PROP = "mail.smtp.user";
    private static final String PASS_PROP = "mail.smtp.clave";
    private static final String AUTH_PROP = "mail.smtp.auth";
    private static final String STARTTLS_PROP = "mail.smtp.starttls.enable";
    private static final String PORT_PROP = "mail.smtp.port";

    private static final String HOST_VALUE= "smtp.gmail.com";
    private static final String USER_VALUE= "eagle_logistics";
    private static final String PASS_VALUE= "12345678";
    private static final String AUTH_VALUE= "true";
    private static final String STARTTLS_VALUE = "true";
    private static final String PORT_VALUE = "587";

    Properties props;

    public MailUtil(){
        this.props = System.getProperties();
        this.props.put(HOST_PROP, HOST_VALUE);
        this.props.put(USER_PROP, USER_VALUE);  //only tour mail without @gmail.com
        this.props.put(PASS_PROP, PASS_VALUE);
        this.props.put(AUTH_PROP, AUTH_VALUE);
        this.props.put(STARTTLS_PROP, STARTTLS_VALUE);
        this.props.put(PORT_PROP, PORT_VALUE);
    }

    public void sendMails(final Set<String> destinations) {
        destinations.forEach(this::sendMail);
    }


    private void sendMail(final String destination) {
        MailModel mail = new MailModel(destination, "subject", "body");
        Session session = Session.getDefaultInstance(this.props);
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("user"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail.getDestination()));
            message.setSubject(mail.getSubject());
            message.setText(mail.getBody());
            Transport transport = session.getTransport(PROTOCOL);
            transport.connect(HOST_VALUE, USER_VALUE, PASS_VALUE);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException me) {
            logger.error("Error to send mail", me);
        }
    }
}
