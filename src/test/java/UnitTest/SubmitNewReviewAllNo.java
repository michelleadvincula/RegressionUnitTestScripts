package UnitTest;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;

import org.testng.Assert;

import org.testng.annotations.Test;



public class SubmitNewReviewAllNo extends CommonFunctions{
		
@Test(priority=3)
		  public void TestSubmitNewReviewAllNo() throws InterruptedException, IOException {
			
		invokeChromeBrowser("chrome");
		//CommonFunctions cf = new CommonFunctions();
		GetLastMedDate gc = new GetLastMedDate();
		GetLastBRDate gb = new GetLastBRDate();
			
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
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
//Click Akash Jadhav in the Search List	
					clickOnElement("ClickConsultantText");
					Thread.sleep(5000);
//Click Begin button
					try {
						clickOnElementJS("BeginButton");
					} catch (ElementClickInterceptedException ignore) {
					
					}
				    
				   
//Enter Contact Number
					element("ContactNumber").sendKeys("123456789000");	    
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
//Choose No Is any part of the scope of practice only undertaken in the private sector?
					clickOnElement("NoChckBxScopeUnderPrivSector");		
//Enter  Please specify details of how competence is maintained
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
//Scroll down
					ScrollDown("NoChckBxMandTrainCompleted");
//Choose No Is all mandatory training completed?
					clickOnElement("NoChckBxMandTrainCompleted");
//Enter Modules not completed
					SendKeys("ModulesNotCompAreaBx","These are the modules 1 2 3");
//Choose No New procedures
					clickOnElement("NoChckBxNwProcedures");
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
//Choose No Are there any concerns  or changes to practice in other hospitals where the doctor works?
					clickOnElement("NoChckBxConcernsChangesDocWorks");
//Choose No  Are there any concerns or changes to recognition from an insurer or commissioner?
					clickOnElement("NoChckBxConcernsChangesRecoInsComm");		
//Choose No Other concerns relating to the doctor's work; including those related to non-technical/soft skills such as situational awareness, coping with stress etc?
					clickOnElement("NoChckBxConcernsOtherConcernsRelDocWorkNonTech");	
//Click Behavior
					clickOnElement("BehaviorMenuButton");
//Choose No Are there any incidents or events relating to conduct or behaviour?
					clickOnElement("NoChckBxIncEveRelBehavior");
//Click Feedback from the Practitioner
					clickOnElement("FeedbackPracMenuButton");
//Enter Feedback
					SendKeys("Feedback","This is an automated message");		
//Click BMI values
					clickOnElement("BMIValuesMenuButton");
//Choose No The Practitioner is aware of the BMI Values
					clickOnElement("NoChckBxPractitionerAwareBMIVal");	
//Choose No The Practitioner has been provided with the latest PP policy and has access to all policies and procedures	
					clickOnElement("NoChckBxPractitionerPPPolicy");		
//Click Service development or commercial opportunities
					clickOnElement("ServiceDevtCommOpportunities");
//Enter service details
					SendKeys("ServiceDetailsAreaBx","This is an automated message");		
//Click Sign off
					clickOnElement("SignOffMenuButton");
//Choose No Renewal of practicing privileges	
					clickOnElement("NoChckBxRenewalPractPriv");
//Choose No Are there any elements of the Biennial review which require escalation to the Corporate Team?
					clickOnElement("NoChckBxEscalationToCorpTeam");		
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
					System.out.println("Hospital is "+hospital);
					driver.quit();
		}
}