package com.game.stepDefinitions;


import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.junit.Assert.*;

import java.time.Duration;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.game.core.BaseFunctions;


public class RummyLogInStepDefinition extends BaseFunctions {



	@Given("777Games app is installed")
	public void is_App_installed() throws InterruptedException {

		if(driver!=null) {
			boolean isavailable=driver.isAppInstalled("com.game.rummy777.stage");
			System.out.println("is_App_installed "+isavailable);
			if(!isavailable) {
				driver.installApp(System.getProperty("user.dir")+"/src/main/resources/app-stage-debug.apk");
				Thread.sleep(4000);
			}
		}

	}

	@When("an unregistered user launches the app")
	public void unregistered_user() {

		driver.launchApp();
		System.out.println("application launched.....");

	}

	@Then("he should see the splash screen \\(animation) for {int} seconds")
	public void flash_screen(int sec) {
		boolean isDisplayed=isElementDispayedById("lavSplash");
		System.out.println(" flash screen is displayed "+isDisplayed);
		assertTrue(isDisplayed);
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		boolean signup=isElementDispayedById("btnSignUpOnboard");
		System.out.println("Is signup displayed "+signup);
		assertTrue(signup);
	}

	@And("he should see the signup screen with a slider")
	public void signup_screen_with_slider() {
		boolean signup=isElementDispayedById("btnSignUpOnboard");
				
		System.out.println("Is signup displayed "+signup);
		assertTrue(signup);
		boolean slider=isElementDispayedById("dotIndicator");
				
		System.out.println("Is slider displayed "+slider);
		assertTrue(slider);

	}

	@Given("user is on the signup\\/login screen")
	public void user_in_signup_screen() {
		boolean signup=isElementDispayedById("btnSignUpOnboard");
				
		System.out.println("Is signup displayed "+signup);
		assertTrue(signup);

		boolean login=isElementDispayedById("btnLogin");
		System.out.println("Is login displayed "+login);
		assertTrue(login);

	}

	@When("user right swipes on the image")
	public void user_right_swipe_screen() {
		int screen_hight=driver.manage().window().getSize().getHeight();
		int screen_width=driver.manage().window().getSize().getWidth();

		TouchAction act=new TouchAction(driver);

		act.press(PointOption.point((int) (screen_width*0.7),screen_hight/2  ))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		.moveTo(PointOption.point((int) (screen_width*0.2),screen_hight/2 )).release().perform();
	}

	@Then("he should see the next image")
	public void next_image() {
		boolean next_image=isElementDispayedById("vpOnboard");
		assertTrue(next_image);
	}

	@And("when he left swipes on the new image")
	public void user_left_swipe_screen() {
		int screen_hight=driver.manage().window().getSize().getHeight();
		int screen_width=driver.manage().window().getSize().getWidth();

		TouchAction act=new TouchAction(driver);

		act.press(PointOption.point((int) (screen_width*0.2),screen_hight/2  ))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		.moveTo(PointOption.point((int) (screen_width*0.7),screen_hight/2 )).release().perform();
	}

	@Then("he should see the previous image")
	public void previous_image() {
		boolean next_image=isElementDispayedById("vpOnboard");
		assertTrue(next_image);
	}

	@When("user clicks on Signup button")
	public void click_on_signUp() {
		driver.findElementById("btnSignUpOnboard").click();
	}

	@Then("he should be on the Signup form screen")
	public void signup_form_screen() throws InterruptedException {
		Thread.sleep(1000);
		wait(5,"btnSignUp");
		boolean signup=driver.findElementById("btnSignUp").isDisplayed();
		System.out.println("Is signup displayed "+signup);
		assertTrue(signup);

	}

	@Given("user is on the Signup page")
	public void signUp_page() {
		boolean signup=isElementDispayedById("btnSignUp");
		System.out.println("Is signup displayed "+signup);
		assertTrue(signup);

	}

	@When("user enters {string} as the Mobile number in {string} page")
	public void enter_Mobile_number_signup(String num,String pageName) {
		
		
		if(pageName.equalsIgnoreCase("login")) {
			driver.findElementById("etLoginMobileNumber").sendKeys(num);
		}else if(pageName.equalsIgnoreCase("signup")) {
			driver.findElementById("etSignUpMobileNumber").sendKeys(num);
			
		}

	}
	
	@And("clicks on Referral code input form")
	public void referral_input() {
		driver.findElementById("etSignUpReferralCode").click();

	}

	@Then("he should see an error message that the number already exists")
	public void error_message_number_already_exists() {
		boolean error_msg=isElementDispayedById("tvSignUpErrorMessage");
		assertTrue(error_msg);
		String msg=driver.findElementById("tvSignUpErrorMessage").getText();
		assertEquals(msg, "This mobile number already exists. Please Login.");
	}

	 @When("user clicks on the {string} button in the top right of thescreen")
	 public void click_On_signin_button_top_right_of_thescreen(String btnName) {
		 MobileElement element=driver.findElementById("tvTopRight");
		 String txt=element.getText();
		 assertEquals(txt,btnName);
		 element.click();
		}

	 @Then("he should navigate to the login form screen")
	 public void navigate_login_form_screen() throws InterruptedException {
		 Thread.sleep(1000);
		 wait(5,"btnLogin");
		 
		}

	 @Given("user is on the login page")
	 public void login_form_screen() {
		 boolean login=isElementDispayedById("btnLogin");
		 assertTrue(login);
		 boolean numBox=isElementDispayedById("etLoginMobileNumber");
		 assertTrue(numBox);
		}

	
	 @And("user clicks on the login button")
	 public void click_on_login_button() {
		driver.findElementById("btnLogin").click();
		}
	 
	 @Then("he should navigate to verify OTP page")
	 public void navigate_to_OTP_page() {
		 wait(5,"tvOtpTitle");
	}
	 	    
	 @Given("user is on the Verify OTP page")
	 public void verify_OTP_page() {
		String txt= driver.findElementById("tvOtpTitle").getText();
		assertEquals(txt, "Enter the 6-digit OTP");
		assertTrue(isElementDispayedById("btnVerify"));
	}
	 
	 @When("user enters {string} as the OTP")
	 public void enter_OTP(String otp) throws InterruptedException {
		 driver.findElementById("etOtpPinView").clear();
		 driver.findElementById("etOtpPinView").sendKeys(otp);
		 Thread.sleep(3000);
		 
			
		} 
	 
	 
	 @Then("user should see an incorrect OTP error message")
	 public void incorrect_OTP_error() {
		 wait(2,"tvOtpError");
		System.out.println("Error otp"); 
			
		} 
	 
	 @Then("the app should crash") 
	 public void app_Crash() {
			String appPack=driver.getCurrentPackage();
			System.out.println("Current package:: "+appPack);
			assertNotEquals(appPack, "com.game.rummy777.stage");
			
				
			} 
		 
	 
	 
	 
}
