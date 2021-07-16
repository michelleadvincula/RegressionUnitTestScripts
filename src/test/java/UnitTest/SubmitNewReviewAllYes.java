package UnitTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SubmitNewReviewAllYes extends CommonFunctions {
@Test(priority=2)
	  public void TestSubmitNewReviewAllYes() throws InterruptedException, IOException {
		
		invokeChromeBrowser("chrome");
		//CommonFunctions cf = new CommonFunctions();
		GetLastMedDate gc = new GetLastMedDate();
		GetLastBRDate gb = new GetLastBRDate();
		
//Call GetNewWindow method
			GetNewWindow(driver);
			Thread.sleep(8000);
//Enter email
				SendKeys("email","Penny.Baker@circlehgdev.com");
				clickOnElement("ClickEmail");
//Call GetNewWindow method 
				GetNewWindow(driver); 
				Thread.sleep(8000);
//Enter password 
				
				 SendKeys("password","Gumu4304");
				 clickOnElement("ClickPassword"); 
//Select Yes to Stay Signed In window 
//Call GetNewWindow method 
				 GetNewWindow(driver);
				  Thread.sleep(8000);
				  clickOnElement("StaySignedIn");
				  Thread.sleep(10000);
//Switch to iframe
				  driver.findElement(By.id("adalRenewFramehttps://service.powerapps.com/"));	
				  driver.switchTo().frame(0); 
//Click Create a new review button
				  clickOnElementJS("CreateNewReviewButton");
				  clickOnElement("CreateNewReviewButton");
//Select Hospital 
				  clickOnElementByID("SelectHospitalComboBx");
				  clickOnElement("SelectHospitalListitem");
//Select Consultant 
//Find Text element 
				  clickOnElement("SelectConsultantComboBx"); 
				  Thread.sleep(5000);
				  element("SelectConsultantClear").clear();
				  SendKeys("SelectConsultantText","akash");
//Click Akash jadhav in the Search List 
				  element("ClickConsultantText").click(); 
				  Thread.sleep(5000); 
//Click Begin button 
				  try { 
					  clickOnElementJS("BeginButton"); 
					  } catch(ElementClickInterceptedException ignore) {
				  
				  }
				  
//Enter Contact Number 
				  SendKeys("ContactNumber","123456789000"); 
//Select Current PP Status
				  clickOnElementByID("CurrentPPStatusComboBx");
				  clickOnElement("CurrentPPStatusList");
//Select Prof Reg Body 
				  clickOnElementByID("ProfRegBodyComboBxID");
				  clickOnElement("ProfRegBodyList"); 
//Enter GMC Number
				  SendKeys("GMCNumber","7777777"); 
//Select Designated body
				  clickOnElementByID("DesignatedBodyID");
				  clickOnElement("DesignatedBodyList"); 
//Enter Responsible officer 
				  SendKeys("ResponsibleOfficer","Jack Responsible"); 
//Click Standard data check compliance
				  clickOnElement("StandardDataCheckMenubutton");
//Select Last medical appraisal date
				  clickOnElement("NwLastMedicalApprasalDateIcon"); 
				  gc.getCurrent(driver);
//Check PDP 
				  clickOnElement("PDP"); 
//Enter Notes
				  SendKeys("Notes","This is an automation test note"); 
//Select Date of last biennial review
				  clickOnElement("DateofLastBR");
				  gb.getBRDate(driver); 
//Check Prof.body.reg
				  clickOnElement("ProfBodyRegCheckBx"); 
//Enter Submission to national registries 
				  SendKeys("SubmissionToNatlRegistriesAreaBx","This is an automated Submission to national registries"); 
//Click Scope of practice
				  clickOnElement("ScopePracticeMenubutton");
//Enter Scope of Practice 
				  SendKeys("ScopePracticeAreaBx","This scope of practice is an automated message");
//Choose Yes Is any part of the scope of practice only undertaken in the private sector? 
				  clickOnElement("YesChckBxScopeUnderPrivSector"); 
//Enter Private sector details 
				  SendKeys("PrivateSecDetailsAreaBx","This Private sector is an automated message"); 
//Enter Please specify details of how competence is maintained 
				  SendKeys("SpecifyDetlsCompetenceMaintainAreaBx","This maintenance instruction is an automated message"); 
//Enter Number of complaints 
				  SendKeys("NumComplaints","1"); 
//Enter Infection rate 
				  SendKeys("InfectionRate","2"); 
//Enter Unexpected deaths 
				  SendKeys("UnexpectedDeaths","3"); 
//Enter Unplanned transfers 
				  SendKeys("UnplannedTransfers","4"); 
//Enter VTE incidents % of patients 
				  SendKeys("VTEInc%Patients","5"); 
//Enter Returns to theatre 
				  SendKeys("ReturnstoTheatre","6"); 
//Enter Readmission 
				  SendKeys("Readmission","7"); 
//Enter Never events 
				  SendKeys("NeverEvents","8"); 
//Choose Yes Is all mandatory training completed? 
				  clickOnElement("YesChckBxMandTrainCompleted"); 
//Choose Yes New procedures 
				  clickOnElement("YesChckBxNwProcedures"); 
//Enter Please provide details below 
				SendKeys("ProcedureDetailsAreaBx","This procedure is automated");
//Click Summary and Discussion
				clickOnElement("SummaryNdDiscussion"); 
//Enter More Details 
				SendKeys("MoreDetailsAreaBx","This is an automated message"); 
//Click Incidents, events, and complaints
				  clickOnElement("IncidentMenuButton");
//Enter any review 
				  SendKeys("AnyReviewAreaBx","This is an automated message");
//Click Concerns or changes
				  clickOnElement("ConcernsOrChanges");
//Choose Yes Are there any concerns or changes to practice in other hospitals where the doctor works? 
				 clickOnElement("YesChckBxConcernsChangesDocWorks"); 
//Enter Please Provide details 
				SendKeys("ProvideDetailsDocWorksAreaBox","This is an automated message"); 
//Choose Yes Are there any concerns or changes to recognition from an insurer or commissioner?
				  clickOnElement("YesChckBxConcernsChangesRecoInsComm"); 
//Enter Please Provide details 
				  SendKeys("ProvideDetailsRecoInsCommAreaBx" ,"This is an automated message");
//Choose Yes Other concerns relating to the doctor's work; including those related to non-technical/soft skills such as situational awareness, coping with stress etc? 
				  clickOnElement("YesChckBxConcernsOtherConcernsRelDocWorkNonTech"); 
//Enter Please Provide details 
				  SendKeys("ProvideDetailsNonTech","This is an automated message"); 
//Click Behavior 
				  clickOnElement("BehaviorMenuButton"); 
//Choose Yes Are there any incidents or events relating to conduct or behaviour?
				  clickOnElement("YesChckBxIncEveRelBehavior"); 
//Enter Please Provide details 
				  SendKeys("IncEveRelBehaviorDetails","This is an automated message"); 
//Click Feedback from the Practitioner
				  clickOnElement("FeedbackPracMenuButton");
//Enter Feedback 
				  SendKeys("Feedback","This is an automated message"); 
//Click BMI values
				 clickOnElement("BMIValuesMenuButton");
//Choose Yes The Practitioner is aware of the BMI Values
				 clickOnElement("YesChckBxPractitionerAwareBMIVal"); 
//Choose Yes The Practitioner has been provided with the latest PP policy and has access to all policies and procedures 
				 clickOnElement("YesChckBxPractitionerPPPolicy"); 
//Click Service development or commercial opportunities 
				 clickOnElement("ServiceDevtCommOpportunities"); 
//Enter service details
				  SendKeys("ServiceDetailsAreaBx","This is an automated message"); 
//Click Sign off 
				  clickOnElement("SignOffMenuButton"); 
//Choose Yes Renewal of practicing privileges 
				  clickOnElement("YesChckBxRenewalPractPriv");
//Choose Yes Are there any elements of the Biennial review which require escalation to the Corporate Team? 
				  clickOnElement("YesChckBxEscalationToCorpTeam"); 
//Enter Please provide details of the elements which require escalation 
				 SendKeys("EscalationDetailsAreaBx","This automated message should display in the Escalation Email sent to an Admin email"); 
//Click Submit 
				 clickOnElement("SubmitButton");
//Click Completed dashboard list
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  ActionOnElement("CompletedTab"); 
//Refresh list
				clickOnElementJS("Refresh");
			    Thread.sleep(10000); 
//Validate submitted review is displayed in Completed Dashboard 
			    String consultant = element("Consultant").getText(); 
			    String expected = "Akash Jadhav"; 
			    Assert.assertEquals(consultant, expected); 
			    String hospital =element("Hospital").getText(); 
			    String expected2 = "The Kings Oak Hospital"; 
			    Assert.assertEquals(hospital, expected2);
				  
			    System.out.println("Consultant is "+consultant);
				System.out.println("Hospital is "+hospital); driver.quit();
				 
}
}

