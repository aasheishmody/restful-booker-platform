package pages;

import base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPanelPage {

    @FindBy(id = "username")
    private WebElement userNameTextbox;
    @FindBy(id = "password")
    private WebElement passwordTextbox;
    @FindBy(id = "doLogin")
    private WebElement loginButton;


    public AdminPanelPage()
    {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void navigateToAdminPage() {
        DriverFactory.getDriver().get("http://localhost:8080/#/admin");
    }

    public boolean iAMOnTheAdminPanelPage() {
        return userNameTextbox.isDisplayed();
    }

    public void login(String userName, String password){
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
