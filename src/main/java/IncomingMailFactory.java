/**
 * Created by mturner on 5/13/16.
 */

import org.apache.commons.io.IOUtils;
import org.subethamail.smtp.*;

import java.io.IOException;
import java.io.InputStream;

public class IncomingMailFactory implements MessageHandlerFactory {


    public MessageHandler create(MessageContext messageContext) {
        return new IncomingMailHandler(messageContext);
    }

    class IncomingMailHandler implements MessageHandler {

        MessageContext ctx;

        public IncomingMailHandler(MessageContext ctx) {
            this.ctx = ctx;
        }

        public void from(String sender) throws RejectException {
            //We could reject with an SMTP code here
            //http://javadox.com/org.subethamail/subethasmtp/3.1.7/org/subethamail/smtp/RejectException.html
            //Instead we will just print the sender's email
            System.out.println(String.format("You've got mail from %s", sender));
        }

        public void recipient(String recipient) throws RejectException {
            //We could reject with an SMTP code here
            //http://javadox.com/org.subethamail/subethasmtp/3.1.7/org/subethamail/smtp/RejectException.html
            //Instead we will just print the recipient's email
            System.out.println(String.format("Yo %s, you've got mail", recipient));
        }

        public void data(InputStream inputStream) throws RejectException, TooMuchDataException, IOException {
            String body = IOUtils.toString(inputStream, "UTF-8");
            String out = "----BODY----\n\n%s\n\n--END BODY--\n\n";
            System.out.println(String.format(out, body));
        }

        public void done() {
            System.out.println("Done processing mail");
        }
    }
}