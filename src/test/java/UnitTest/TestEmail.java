package UnitTest;



import javax.mail.Message;

import org.testng.annotations.Test;

public class TestEmail {

	@Test
	public void TestOutlookEmail() throws Exception {
		verifyEmail cf = new verifyEmail();
	
	Message mail = cf.getEmail("alex.franklin@ccbmidev.onmicrosoft.com", "Nubu7830", "Biennial review submitted for The Park Hospital");
	 System.out.println("***************************************************");
     System.out.println("MESSAGE : \n");

   
     System.out.println("Body: \n" + cf.getEmailBody(mail));
     System.out.println("Has Attachments: " + cf.hasAttachments(mail));
     System.out.println("Subject: " + mail.getSubject());
     System.out.println("From: " + mail.getFrom()[0]);
     System.out.println("To: " + mail.getAllRecipients()[0]);
     System.out.println("Date: " + mail.getReceivedDate());
     System.out.println("ContentType: " + mail.getContentType());
   
	}
}
