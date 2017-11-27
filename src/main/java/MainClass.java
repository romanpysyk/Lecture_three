import org.openqa.selenium.WebDriver;

public class MainClass{
    public static void main (String [] args) throws InterruptedException {

        WebDriver driver = DriverConfigurations.getDriver("chrome");
        PageObjects loginActions = new PageObjects(driver);
        loginActions.open();
        loginActions.fillEmail();
        loginActions.fillPassword();
        loginActions.clickLogin();
        loginActions.clickOnCategories();
        loginActions.clickOnNew();
        loginActions.fillName();
        loginActions.scrollDown(0, 1600);
        loginActions.clickOnSave();
        loginActions.verifySaving();
        loginActions.scrollDown(0, 200);
        loginActions.verifyResultOfSearch();
        loginActions.logout();
        driver.quit();
    }
}
