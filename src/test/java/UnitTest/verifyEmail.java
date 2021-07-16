package UnitTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;
import javax.mail.search.SubjectTerm;

import org.apache.commons.codec.binary.Base64;


public class verifyEmail {

	public Message getEmail(String emailID, String password, String subjectToBeSearched) throws Exception {
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");

		Session session = Session.getDefaultInstance(props, null);
		Store store = session.getStore("imaps");
		store.connect("outlook.office365.com", "akash@ccbmidev.onmicrosoft.com", "Nuno0506");

		Folder folder = store.getFolder("Inbox");
		folder.open(Folder.READ_WRITE);

		Message[] messages = null;
		boolean mailFound = false;
		Message email = null;

		for (int i = 0; i < 5; i++) {
		    messages = folder.search(new SubjectTerm(subjectToBeSearched), folder.getMessages());
		    if (messages.length == 0) {
		        Thread.sleep(10000);
		    }
		}

		for (Message mail : messages) {
		    if (!mail.isSet(Flags.Flag.SEEN)) {
		        email = mail;
		        mailFound = true;
		    }
		}

		if (!mailFound) {
		    throw new Exception("Could not found Email");
		}

		return email;
		}

	public boolean hasAttachments(Message email) throws Exception {

	    // suppose 'message' is an object of type Message
	    String contentType = email.getContentType();
	    System.out.println(contentType);

	    if (contentType.toLowerCase().contains("multipart/mixed")) {
	        // this message must contain attachment
	        Multipart multiPart = (Multipart) email.getContent();

	        for (int i = 0; i < multiPart.getCount(); i++) {
	            MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(i);
	            if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
	                System.out.println("Attached filename is:" + part.getFileName());
	            }
	        }

	        return true;
	    }
		return false;

	}

	public String getEmailBody(Message email) throws IOException, MessagingException {

	    String line, emailContentEncoded;
	    StringBuffer bufferEmailContentEncoded = new StringBuffer();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(email.getInputStream()));
	    while ((line = reader.readLine()) != null) {
	        bufferEmailContentEncoded.append(line);
	    }

	    System.out.println("**************************************************");

	    //System.out.println(bufferEmailContentEncoded);

	    System.out.println("**************************************************");

	    emailContentEncoded = bufferEmailContentEncoded.toString();

	    if (email.getContentType().toLowerCase().contains("multipart/mixed")) {

	        emailContentEncoded = emailContentEncoded.substring(emailContentEncoded.indexOf("base64") + 6);
	        emailContentEncoded = emailContentEncoded.substring(0, emailContentEncoded.indexOf("Content-Type") - 1);

	        System.out.println(emailContentEncoded);

	        String emailContentDecoded = new String(new Base64().decode(emailContentEncoded.toString().getBytes()));
	        return emailContentDecoded;
	    }

	    return emailContentEncoded;

	}
	
}