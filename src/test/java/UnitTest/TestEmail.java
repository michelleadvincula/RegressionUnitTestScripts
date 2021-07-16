package UnitTest;



import javax.mail.Message;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.testng.annotations.Test;

public class TestEmail {

	@Test
	public void TestOutlookEmail() throws Exception {
		verifyEmail cf = new verifyEmail();
	
	Message mail = cf.getEmail("akash@ccbmidev.onmicrosoft.com", "Nuno0506", "Biennial review submitted for The Kings Oak Hospital");
	 System.out.println("***************************************************");
     System.out.println("MESSAGE : \n");

     String EmailBody = cf.getEmailBody(mail).toString();
     Document html = Jsoup.parse(EmailBody);
     String printCleanBody = html.body().getElementsByTag("body").text();
     
     System.out.println("Body: \n" + printCleanBody);
     System.out.println("Has Attachments: " + cf.hasAttachments(mail));
     System.out.println("Subject: " + mail.getSubject());
     System.out.println("From: " + mail.getFrom()[0]);
     System.out.println("To: " + mail.getAllRecipients()[0]);
     System.out.println("Date: " + mail.getReceivedDate());
     System.out.println("ContentType: " + mail.getContentType());
   
	}
}
