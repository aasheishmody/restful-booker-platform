package pages;

import base.Page;
import base.SharedDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ConfigFileReader;

public class AdminPanelPage extends Page {

    @FindBy(id = "username")
    private WebElement userNameTextbox;
    @FindBy(id = "password")
    private WebElement passwordTextbox;
    @FindBy(id = "doLogin")
    private WebElement loginButton;

    private final static String ADMINPANELPAGEURL = ConfigFileReader.getInstance().getBaseUrl() + "/#/admin";

    public void navigateToAdminPage() {
        SharedDriver.getDriver().get(ADMINPANELPAGEURL);
    }

    public boolean iAMOnTheAdminPanelPage() {
        return userNameTextbox.isDisplayed();
    }

    public void login(String userName, String password) {
        enterUsername(userName);
        enterPassword(password);
        clickLoginButton();
    }

    private void enterUsername(String userName) {
        userNameTextbox.sendKeys(userName);
    }

    private void enterPassword(String password) {
        passwordTextbox.sendKeys(password);
    }

    private void clickLoginButton() {
        loginButton.click();
    }
}
