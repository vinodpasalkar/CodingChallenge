package net.webtestautomation.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.FindBy;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.WebDriverFacade;
import net.webtestautomation.pages.mobilePage.MobilePageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//This class is used for all UI actions and extends common class MobilePageObject which contains driver and common methods
public class SearchResultsPage  {

    @FindBy(xpath="//img[@id='gh-logo']")
    @AndroidFindBy(xpath="")
    @iOSFindBy(xpath = "")
    private WebElement eBayLogo;

    @FindBy(xpath="//a[contains(text(),'register')]")
    private WebElement registerLink;

    @FindBy(xpath="//*[@id=\"gh-ac\"]")
    private WebElement searchTextBox;

    @FindBy(xpath="//*[@id=\"gh-btn\"]\n")
    private WebElement searchButton;

    //@FindBy(xpath="//span[contains(text(),'£')]")
    @FindBy(css = "[class*='s-item__price']")
    private WebElement itemPrice;

    @FindBy(css = "[class*='s-item__shipping s-item__logisticsCost']")
    private WebElement itemPostagePrice;


    @FindBy(xpath="//div[@id='w9']//*[@class='svg-icon x-flyout-arrow-down']")
    private WebElement filterMenu;

    @FindBy(xpath="//*[@id=\"w9\"]/div/div/ul/li[5]/a/span")
    private WebElement lowestPriceFilter;

    @FindBy(xpath="//*[@id=\"w9\"]/div/div/ul/li[4]/a/span")
    private WebElement highestPriceFilter;

    @FindBy(xpath="//*[@id=\"w4\"]/li[1]/ul/li[5]/ul/li[3]/div/a")
    private WebElement buyItNow;

    @FindBy(className="s-item__buy-it-now-icon")
    private WebElement buyItNowTag;

    @FindBy(id="gh-shop-ei")
    private WebElement categoryMenu;

    @FindBy(className="ebayui-image-chevron-light-left")
    private WebElement paginationLeftArrow;

    @FindBy(className="x-pagination__li x-pagination__li--selected")
    private WebElement paginationPages;

    @FindBy(xpath="//li[@class='x-pagination__li x-pagination__li--selected']//a[contains(text(),'1')]")
    private WebElement paginationPage1;

    @FindBy(xpath="//li[@class='x-pagination__li']//a[contains(text(),'2')]")
    private WebElement paginationPage2BeforeClick;

    @FindBy(xpath="//li[@class='x-pagination__li x-pagination__li--selected']//a[contains(text(),'2')]")
    private WebElement paginationPage2AfterClick;


    @Step("Step {0}")
    public void generateStep(String s){
    }

   String matchingResult = "//h3[contains(text(),'searchString')]";
   String filerOption = "//span[contains(text(),'FilterOption')]";
   String categoryString = "//a[contains(text(),\"categoryName\")]";
   String selectedCategoryString = "//strong[contains(text(),\"categoryName\")]";

    private  String platform = System.getProperty("platform");

    //Added this to use driver in this base class
    private  WebDriver driver ;

    List<BigDecimal> DoubleList1 = new ArrayList<BigDecimal>();
    List<BigDecimal> DoubleList2 = new ArrayList<BigDecimal>();
    /*Array list named as sortedPrices and passing integer list into it to sort*/
    ArrayList<BigDecimal> sortedPrices = new ArrayList<BigDecimal>(DoubleList1);

    public SearchResultsPage() {

        WebDriverManager.chromedriver().setup();
        //Create driver object for Chrome
        this.driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
    }

    //Opens the given website in the browser
    public void gotoSiteOnBrowser() {

        System.out.println("Launching the site in browser");
        driver.get("http://www.ebay.co.uk/");
        generateStep("Ebay site is launched successfully");

        if(registerLink.isDisplayed()){
            generateStep("Non-registered user is using the site");
        }
        else{
            Assert.fail("Registered user is using the site");

        }
    }

    //Verifies the Ebay site Logo
    public void verifyWebPageLogoOnUI() {
        if(eBayLogo.isDisplayed()){
            generateStep("Ebay home page logo is displayed");
        }
        else{
            Assert.fail("Ebay home page logo is not displayed");

        }

    }

    //Verifies what type of user is using the site
    public void verifyNonExistingUser() {
        // This requirement is bit confusing as its written before seeing the actual webpage
        // Otherwise if we have user details somewhere in the framework config we can check in the backend with database  query
        // Or with the help of REST API call

        /*if(registerLink.isDisplayed()){
            generateStep("Non registered user has opened the page");
        }
        else{
            generateStep("Registered user has opened the page");
            Assert.fail("Registered user has opened the page");
        }*/
    }

    //Enters the search item name into the search text box
    public void searchForItemOnUI(String itemName) {
        searchTextBox.sendKeys(itemName);
        searchButton.click();
        generateStep("Searched for an item "+itemName);
    }

    //Verifies the results are matching to the search item
    public void verifyResultOnUI(String searchItemString) {
        String updatedMatchingString = matchingResult.replace("searchString",searchItemString);
        scrollOnPage(driver.findElement(By.xpath(updatedMatchingString)));
        if (driver.findElement(By.xpath(updatedMatchingString)).isDisplayed()){
            generateStep("Matching results are displayed for item "+searchItemString);
        }
        else{
            generateStep("Matching results are not displayed for item "+searchItemString);
            Assert.fail("Matching results are not displayed for item "+searchItemString);
        }
    }

    //Verifies UI elements on product search results page.
    public void verifyProductPageUI() {
        String bidsNumber = "//span[contains(text(),'bids')]";
        String butItNowTag = "[class*='s-item__buy-it-now-icon']";
        if(itemPrice.isDisplayed()){
            generateStep("Product prices are shown");
        }
        else{
            generateStep("Product prices are not shown");
            Assert.fail("Product prices are not shown");
        }
        if(itemPostagePrice.isDisplayed()){
            generateStep("Product postage prices are shown");
        }
        else{
            generateStep("Product postage prices are not shown");
            Assert.fail("Product  postageprices are not shown");
        }

        if(driver.findElements(By.xpath(bidsNumber)).size() >0){
            generateStep("Number of bids are shown");
        }
        else{
            generateStep("Number of bids are not shown");
        }

        if(driver.findElements(By.cssSelector(butItNowTag)).size()>0){
            generateStep("Buy it Now tags are shown");
        }
        else{
            generateStep("Buy it Now tags are not shown");
        }
    }

    public void verifyItemsOrder() {
        verifySortOrderOnUI();
    }

    private void verifySortOrderOnUI() {
        getPricesBefore();
        getPricesAfter();
        Assert.assertEquals(DoubleList1,DoubleList2);
    }

    private void getPricesBefore() {
        List<WebElement> table = driver.findElements(By.cssSelector("[class*='s-item__price']"));
        ArrayList<String> Prices1 = new ArrayList<String>();


        for(int i=0;i<table.size();i++){
            Prices1.add(table.get(i).getText().replace("£", "").replace(",", ""));
        }
        System.out.println("prices are "+Prices1);
        System.out.println("Page 1 consists of " +Prices1.size()+ "  price elements");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*converting string list Prices1 to integer list */
        for (String s: Prices1){
            DecimalFormat df = new DecimalFormat();
            df.setParseBigDecimal(true);
            try {
                DoubleList1.add((BigDecimal) df.parse(s));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Integerlist1 is "+DoubleList1);

        Collections.sort(sortedPrices);
        System.out.println("Sorted list is "+sortedPrices);
    }

    private void getPricesAfter(){
        List<WebElement>table2= driver.findElements(By.cssSelector("[class*='s-item__price']"));

        ArrayList<String> Prices2 = new ArrayList<String>();
        for(int i=0;i<table2.size();i++){
            Prices2.add(table2.get(i).getText().replace("£", "").replace(",", ""));
        }
        System.out.println("price2 are "+Prices2);
        /*converting string list to integer list */
        for (String s1: Prices2){
            DecimalFormat df = new DecimalFormat();
            df.setParseBigDecimal(true);
            try {
                DoubleList2.add((BigDecimal) df.parse(s1));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Integer2 list is "+DoubleList2);

    }

    public void sortResultsOnUI(String sortValue) {
        selectSortValue(sortValue);
    }

    private void selectSortValue(String sortValue) {
        mouseOverElement(filterMenu);
        switch(sortValue.toUpperCase()){
            case "LOWEST PRICE":
                lowestPriceFilter.click();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case "HIGHEST PRICE":
                highestPriceFilter.click();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            default:
                Assert.fail("Please provide valid sort option, "+sortValue+" seems invalid");
        }
    }

    public void checkTagOnUI(String tagName) {
        switch(tagName.toUpperCase()){
            case "BUY IT NOW":
                if(buyItNowTag.isDisplayed()){
                    generateStep(tagName+" is visible");
                }
                else{
                    generateStep(tagName+" is not visible");
                }

                break;
        }
    }

    public void enterSearchTermAndCategoryOnUI(String searchTerm,String searchCategory) {
        categoryString = categoryString.replace("categoryName",searchCategory);
        searchTextBox.sendKeys(searchTerm);
        categoryMenu.click();
        driver.findElement(By.xpath(categoryString)).click();
    }

    public void checkResultsForCategoryOnUI(String searchCategory) {
        selectedCategoryString = selectedCategoryString.replace("categoryName",searchCategory);
        if(driver.findElement(By.xpath(selectedCategoryString)).isDisplayed()){
            generateStep("Results are shown for "+searchCategory);
        }
        else{
            Assert.fail("Results are not shown for "+searchCategory);
        }

    }

    public void VerifyResultsOnMultiplePages() {
        scrollOnPage(paginationLeftArrow);
        if(paginationPage1.isDisplayed()){
            generateStep("Multiple pages are shown and current page is page number 1");
        }
        else{
            Assert.fail("Multiple pages are not shown");
        }
    }

    public void verifyPageNavigationOnUI() {
        if(paginationPage2BeforeClick.isDisplayed()){
            generateStep("Next page link is displayed");
        }
        else{
            Assert.fail("Next page link is not displayed");

        }
        paginationPage2BeforeClick.click();
        scrollOnPage(paginationPage2AfterClick);
        if(paginationPage2AfterClick.isDisplayed()){
            generateStep("Next page is displayed");
        }
        else{
            Assert.fail("Next page is not displayed");
        }
    }

    public void setFilterOnUI(String filterOption) {
        switch(filterOption.toUpperCase()){
            case "BUY IT NOW":
                buyItNow.click();
                break;
            default:
                Assert.fail("Please provide valid filter option, "+filterOption+" seems invalid");
        }
    }

    public void mouseOverElement(WebElement element)
    {
        System.out.println("Hovering over an element");
        generateStep("Hovering over an element");
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }


    //Scrolls on the page until element is visible
    public void scrollOnPage(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
