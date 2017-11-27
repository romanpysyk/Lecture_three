import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;

import java.util.List;


public class PageObjects {
    private WebDriver driver;
    Logger log = Logger.getLogger("devpinoyLogger");

    private final String baseURL = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
    private final String emailValue = "webinar.test@gmail.com";
    private final String passwordValue = "Xcg7299bnSmMuRLp9ITw";
    private final String myCategoryName = "PysykTestCategory";
    private final By catalog = By.xpath("//*[@data-submenu='9']");
    private final By category = By.xpath("//*[@data-submenu='11']");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("passwd");
    private final By loginButton = By.name("submitLogin");
    private final By newButton = By.xpath("//*[@id='page-header-desc-category-new_category']/div");
    private final By nameTextField = By.id("name_1");
    private final By saveButon = By.xpath("//*[@id='category_form_submit_btn']");
    private final By successfullSave = By.xpath("//*[@id='content']/div[3]/div");
    private final By searchField = By.name("categoryFilter_name");
    private final By searchButton = By.id("submitFilterButtoncategory");
    private final By userIcon = By.xpath("//img[@class='imgm img-thumbnail']");
    private final By logout = By.id("header_logout");
    private final By searchResult = By.xpath("//table[@id='table-category']/tbody/tr/td[3]");

    PageObjects(WebDriver driver){
        this.driver = driver;
    }

    void open() {
        driver.get(baseURL);
        log.debug("Opening tested application");
    }

    void fillEmail () {
        driver.findElement(emailField).sendKeys(emailValue);
        log.debug("Filling email field");
    }

    void fillPassword() {
        driver.findElement(passwordField).sendKeys(passwordValue);
        log.debug("Filling password field");
    }

    void clickLogin() {
        driver.findElement(loginButton).click();
        log.debug("Clicking on Login button");
    }

    void clickOnCategories() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalog));
        WebElement catalogItem = driver.findElement(catalog);
        WebElement categoriesItem = driver.findElement(category);
        Actions action = new Actions(driver);
        action.moveToElement(catalogItem).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(category));
        action.click(categoriesItem).perform();
        log.debug("Hovering on Catalog menu item and clicking on Categories submenu item");
    }

    void clickOnNew() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(newButton));
        driver.findElement(newButton).click();
        log.debug("Clicking on New button to create new Category");
    }

    void fillName() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameTextField));
        driver.findElement(nameTextField).sendKeys(myCategoryName);
        log.debug("Entering new Category Name");
    }

    void scrollDown(int a, int b) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(" + a + "," + b +")");
        log.debug("Scrolling page down");
    }

    void clickOnSave() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveButon));
        driver.findElement(saveButon).click();
    }

    void verifySaving() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(successfullSave));
        driver.findElement(successfullSave).isDisplayed();
        log.debug("Clicking on Save button");
    }

    void search() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        driver.findElement(searchField).sendKeys(myCategoryName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
        driver.findElement(searchButton).click();
        log.debug("Searching for new created Category");
    }

    void verifyResultOfSearch() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResult));
        List<WebElement> searchResults = driver.findElements(searchResult);

        for(WebElement e : searchResults) {
            if(e.getText().contains(myCategoryName)) {
                System.out.println("Test passed");
            }
        }
        log.debug("Verifying that new created Category is present in search results");
    }

    void logout() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userIcon));
        driver.findElement(userIcon).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(logout));
        driver.findElement(logout);
        log.debug("Logging out ...");
    }



}
