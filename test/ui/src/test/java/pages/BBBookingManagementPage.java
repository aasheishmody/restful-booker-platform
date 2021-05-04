package pages;

import base.DriverFactory;
import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BBBookingManagementPage extends Page {
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
    
    public boolean iAmOnTheBBBookingManagementPage() {
             return createButton.isDisplayed();
    }

    public void enterRoomBookingDetails(String roomNumber, String roomType, String accessible, String roomPrice, String wiFi, String tv, String radio, String refreshments, String safe, String views) throws Exception {
        String id = "roomNumber" +roomNumber;
        try {
            if (DriverFactory.getDriver().findElement(By.id(id)).isDisplayed())
                throw new Exception("Room number is not available");
        }catch (NoSuchElementException e){
            System.out.println("Room number " +roomNumber+  " is available");
        }
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

    public boolean newRoomBookingIsDisplayed(String roomNumber, String roomType, String accessible, String price, String wifi, String tv, String radio, String refreshments, String safe, String views) {
        String id = "roomNumber" +roomNumber;
        WebElement roomNumberLocator = DriverFactory.getDriver().findElement(By.id(id));
        String roomNumberLocatorXpath = "//*[@id='" +id+ "']/following::div/p";
        WebElement roomTypeLocator = DriverFactory.getDriver().findElement(By.xpath(roomNumberLocatorXpath));
        String accessibleLocatorXpath = roomNumberLocatorXpath + "/following::div/p";
        WebElement accessibleLocator = DriverFactory.getDriver().findElement(By.xpath(accessibleLocatorXpath));
        String priceLocatorXpath = accessibleLocatorXpath + "/following::div/p";
        WebElement priceLocator = DriverFactory.getDriver().findElement(By.xpath(priceLocatorXpath));
        String detailsLocatorXpath = priceLocatorXpath + "/following::div/p";
        WebElement detailsLocator = DriverFactory.getDriver().findElement(By.xpath(detailsLocatorXpath));

        boolean wifiDetails = false;
        if(wifi.equalsIgnoreCase("√"))
        wifiDetails = detailsLocator.getText().contains("WiFi");
        else
            wifiDetails = !(detailsLocator.getText().contains("WiFi"));

        boolean tvDetails = false;
        if(tv.equalsIgnoreCase("√"))
            tvDetails = detailsLocator.getText().contains("TV");
        else
            tvDetails = !(detailsLocator.getText().contains("TV"));

        boolean radioDetails = false;
        if(radio.equalsIgnoreCase("√"))
            radioDetails = detailsLocator.getText().contains("Radio");
        else
            radioDetails = !(detailsLocator.getText().contains("Radio"));

        boolean refreshmentsDetails = false;
        if(refreshments.equalsIgnoreCase("√"))
            refreshmentsDetails = detailsLocator.getText().contains("Refreshments");
        else
            refreshmentsDetails = !(detailsLocator.getText().contains("Refreshments"));

        boolean safeDetails = false;
        if(safe.equalsIgnoreCase("√"))
            safeDetails = detailsLocator.getText().contains("Safe");
        else
            safeDetails = !(detailsLocator.getText().contains("Safe"));

        boolean viewsDetails = false;
        if(views.equalsIgnoreCase("√"))
            viewsDetails = detailsLocator.getText().contains("Views");
        else
        viewsDetails = !(detailsLocator.getText().contains("Views"));



        return roomNumberLocator.getText().equalsIgnoreCase(roomNumber) &&
                roomTypeLocator.getText().equalsIgnoreCase(roomType) &&
                accessibleLocator.getText().equalsIgnoreCase(accessible) &&
                priceLocator.getText().equalsIgnoreCase(price) &&
                wifiDetails && tvDetails && radioDetails && refreshmentsDetails && safeDetails && viewsDetails;

    }
}
