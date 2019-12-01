package net.webtestautomation.pages.mobilePage;

import com.google.common.base.Predicate;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//This is common class for common methods and extends PageObject
public class MobilePageObject extends PageObject {

	@Step("Step {0}")
	public void generateStep(String s){
	}

	private WebElement dashboardActiveStatusforDevice;
	private WebElement dashboardInActiveStatusforDevice;
	private static final int count = 1;
	private Dimension screenSize;
	String dbActiveStatusforDevice = "//android.widget.TextView[contains(@text,\"deviceName\")]";
	String dbInactiveStatusforDevice = "//android.widget.TextView[contains(@text,\"deviceName\")]";

	private WebElement settingsIcon;
	//Added this to use drive in this base class
	private final WebDriver driver = ((WebDriverFacade) getDriver()).getProxiedDriver();


	WebDriverWait webDriverwait = new WebDriverWait(driver, 10);


	public MobilePageObject(WebDriver driver) {
		super(driver, new Predicate<PageObject>() {
			@Override
			public boolean apply(PageObject page) {

				PageFactory
						.initElements(new AppiumFieldDecorator(((WebDriverFacade) page.getDriver()).getProxiedDriver()), page);
				return true;
			}

		});

	}

	public void mouseOverElement(WebElement element)
	{
		System.out.println("Hovering over an element");
		generateStep("Hovering over an element");
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	//Generic Click Method -  locator to the passed
	public void mobClickElement(WebElement locator) {
		//change to for loop with seconds parameterized - return boolean - click if true
		try {
			WebElement temp = webDriverwait.until(ExpectedConditions.visibilityOf(locator));
			element(temp).click();
			Assert.assertTrue("Clicked on " + locator + " Successful", true);
		} catch (Exception e) {
			Assert.assertFalse("Clicked on " + locator + " Failed", true);
		}
	}

	//Scrolls on the page until element is visible
    public void scrollOnPage(WebElement element){
        //WebElement element = driver.findElement(By.id("id_of_element"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
