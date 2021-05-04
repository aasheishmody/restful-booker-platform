package pages;

import base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BBBookingManagementPage {
    @FindBy(id = "roomNumber")
    private WebElement roomNumberTextbox;
    @FindBy(id = "type")
    private WebElement roomTypeDropdown;
    @FindBy(id = "accessible")
    private WebElement accessibleDropdown;
    @FindBy(id = "roomPrice")
    private WebElement roomPriceTextbox;
    @FindBy(id = "wifiCheckbox")
    private WebElement wifiCheckbox;
    @FindBy(id = "tvCheckbox")
    private WebElement tvCheckbox;
    @FindBy(id = "radioCheckbox")
    private WebElement radioCheckbox;
    @FindBy(id = "refreshCheckbox")
    private WebElement refreshmentsCheckbox;
    @FindBy(id = "safeCheckbox")
    private WebElement safeCheckbox;
    @FindBy(id = "viewsCheckbox")
    private WebElement viewsCheckbox;
    @FindBy(id = "createRoom")
    private WebElement createButton;


    public BBBookingManagementPage()
    {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }
    
    public boolean iAmOnTheBBBookingManagementPage() {
             return createButton.isDisplayed();
    }

    public void enterRoomBookingDetails(String roomNumber, String roomType, String accessible, String roomPrice, String wiFi, String tv, String radio, String refreshments, String safe, String views){
        enterRoomNumber(roomNumber);
        selectRoomType(roomType);
        selectAccessible(accessible);
        enterPrice(roomPrice);
        selectWifi(wiFi);
        selectTV(tv);
        selectRadio(radio);
        selectRefreshments(refreshments);
        selectSafe(safe);
        selectViews(views);
    }

    private void enterRoomNumber(String roomNumber) {
        roomNumberTextbox.sendKeys(roomNumber);
    }

    private void selectRoomType(String roomType) {
        Select roomTypeDropdown = new Select(this.roomTypeDropdown);
        roomTypeDropdown.selectByVisibleText(roomType);
    }

    private void selectAccessible(String accessible) {
        Select accessibleDropdown = new Select(this.accessibleDropdown);
        accessibleDropdown.selectByVisibleText(accessible);
    }

    private void enterPrice(String roomPrice) {
        roomPriceTextbox.sendKeys(roomPrice);
    }

    private void selectWifi(String wiFi) {
        if (wiFi.equals("√"))
            wifiCheckbox.click();
    }

    private void selectTV(String tv) {
        if (tv.equals("√"))
            tvCheckbox.click();
    }

    private void selectRadio(String radio) {
        if (radio.equals("√"))
            radioCheckbox.click();
    }

    private void selectRefreshments(String refreshments) {
        if (refreshments.equals("√"))
            refreshmentsCheckbox.click();
    }

    private void selectSafe(String safe) {
        if (safe.equals("√"))
            safeCheckbox.click();
    }

    private void selectViews(String views) {
        if (views.equals("√"))
            viewsCheckbox.click();
    }

    public void clickCreateButton() {
        createButton.click();
    }
}
