package net.webtestautomation;


import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.annotations.Managed;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.BeforeStory;
import org.openqa.selenium.WebDriver;

//import net.webtestautomation.appium.AppiumServer;

public class AcceptanceTestSuite extends SerenityStories {

	
    @Managed(uniqueSession = false)
    public WebDriver webdriver;

    @BeforeStory
    public void beforeStory() {
    	 System.out.println("--- Before Story Ends---");
    }
        
    
    @BeforeStories
    public void startAppium() {
       /* System.setProperty("honeycombURL","");
        System.setProperty("beekeeperURL","");
        System.setProperty("username","betatest1");
        System.setProperty("password","Test1234");
        TranslationTest test = new TranslationTest();
        test.changeToFrench();
        test.updateProductDetails();*/
        //AppiumServer.stopAppiumServer();
        //AppiumServer.startAppiumServer();
    }

    @AfterStory
    public void afterStory() {
    	System.out.println("--- After Story Ends---");
    }
    
    @AfterStories
    public static void stopAppium() {
        //AppiumServer.stopAppiumServer();
    }
    
  
        
}
