/**
 * Created by mturner on 5/13/16.
 */

import org.subethamail.smtp.server.SMTPServer;

public class Main {
    public static void main(String[] args) {

        IncomingMailFactory messageHandlerFactory = new IncomingMailFactory();
        SMTPServer smtpServer = new SMTPServer(messageHandlerFactory);
        smtpServer.setSoftwareName("PLEASEWORK MAIL - POWERED BY SUBETHA");
        smtpServer.setPort(25000);
        smtpServer.start();
    }
}
