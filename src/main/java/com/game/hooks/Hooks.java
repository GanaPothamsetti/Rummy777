package com.game.hooks;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.game.core.BaseFunctions;


import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

import io.cucumber.java.Scenario;




public class Hooks extends BaseFunctions  {
	@Before
	public void startAppium(Scenario scenario) {
		System.out.println("Started testing scenario ::"+scenario.getName());
	}


	@After
	public void StopAppium(Scenario scenario) {
		System.out.println("Completed testing scenario ::"+scenario.getName());
		
	}

	@AfterStep
	public void takeScreenshot(Scenario scenario) {//Scenario scenario, Step step
		try {
			
			File scrFile = (File) ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,new File(System.getProperty("user.dir")+"/screenshot/"+"Screenshots_"+reportTime+"/"+stepName.replaceAll("[^\\dA-Za-z ]", "").replace(" ","_") +".png"));
		} catch (IOException e) {

			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}


	}


}
