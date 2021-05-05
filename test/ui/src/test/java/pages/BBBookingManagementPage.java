package pages;

import base.Page;
import base.SharedDriver;
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

        //Implemented mechanism so booking with same room number cannot be added again
        String id = "roomNumber" + roomNumber;
        try {
            if (SharedDriver.getDriver().findElement(By.id(id)).isDisplayed())
                throw new Exception("Room number is not available");
        } catch (NoSuchElementException e) {
            System.out.println("Room number " + roomNumber + " is available");
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

        //room id is dynamic based on the room number so had to adopt the following approach to access the details of the room booking with a specific room number
        String currentRoomId = "roomNumber" + roomNumber;
        WebElement currentRoomNumber = SharedDriver.getDriver().findElement(By.id(currentRoomId));
        String currentRoomNumberXpath = "//*[@id='" + currentRoomId + "']";

        String roomTypeLocatorXpath = currentRoomNumberXpath + "/following::div/p";
        WebElement roomTypeLocator = SharedDriver.getDriver().findElement(By.xpath(roomTypeLocatorXpath));

        String accessibleLocatorXpath = roomTypeLocatorXpath + "/following::div/p";
        WebElement accessibleLocator = SharedDriver.getDriver().findElement(By.xpath(accessibleLocatorXpath));

        String priceLocatorXpath = accessibleLocatorXpath + "/following::div/p";
        WebElement priceLocator = SharedDriver.getDriver().findElement(By.xpath(priceLocatorXpath));

        String detailsLocatorXpath = priceLocatorXpath + "/following::div/p";
        WebElement detailsLocator = SharedDriver.getDriver().findElement(By.xpath(detailsLocatorXpath));

        boolean wifiDetails = false;
        if (wifi.equalsIgnoreCase("√"))
            wifiDetails = detailsLocator.getText().contains("WiFi");
        else
            wifiDetails = !(detailsLocator.getText().contains("WiFi"));

        boolean tvDetails = false;
        if (tv.equalsIgnoreCase("√"))
            tvDetails = detailsLocator.getText().contains("TV");
        else
            tvDetails = !(detailsLocator.getText().contains("TV"));

        boolean radioDetails = false;
        if (radio.equalsIgnoreCase("√"))
            radioDetails = detailsLocator.getText().contains("Radio");
        else
            radioDetails = !(detailsLocator.getText().contains("Radio"));

        boolean refreshmentsDetails = false;
        if (refreshments.equalsIgnoreCase("√"))
            refreshmentsDetails = detailsLocator.getText().contains("Refreshments");
        else
            refreshmentsDetails = !(detailsLocator.getText().contains("Refreshments"));

        boolean safeDetails = false;
        if (safe.equalsIgnoreCase("√"))
            safeDetails = detailsLocator.getText().contains("Safe");
        else
            safeDetails = !(detailsLocator.getText().contains("Safe"));

        boolean viewsDetails = false;
        if (views.equalsIgnoreCase("√"))
            viewsDetails = detailsLocator.getText().contains("Views");
        else
            viewsDetails = !(detailsLocator.getText().contains("Views"));


        return currentRoomNumber.getText().equalsIgnoreCase(roomNumber) &&
                roomTypeLocator.getText().equalsIgnoreCase(roomType) &&
                accessibleLocator.getText().equalsIgnoreCase(accessible) &&
                priceLocator.getText().equalsIgnoreCase(price) &&
                wifiDetails && tvDetails && radioDetails && refreshmentsDetails && safeDetails && viewsDetails;

    }

    public void clickXButton(String roomNumber) throws Exception {

        //room id is dynamic based on the room number so had to adopt the following approach to access the 'x' button of the room booking with a specific room number
        String currentRoomId = "roomNumber" + roomNumber;
        try {
            if (SharedDriver.getDriver().findElement(By.id(currentRoomId)).isDisplayed()) {
                String currentRoomNumberXpath = "//*[@id='" + currentRoomId + "']";
                String currentRoomNumberXButtonXpath = currentRoomNumberXpath + "/following::div/span[contains(@class, 'roomDelete')]";
                WebElement currentRoomBookingXButton = SharedDriver.getDriver().findElement(By.xpath(currentRoomNumberXButtonXpath));
                currentRoomBookingXButton.click();
            }
        } catch (NoSuchElementException e) {
            throw new Exception("There is no booking with room number " + roomNumber);
        }
    }

    public boolean roomBookingIsDisplayed(String roomNo) {
        SharedDriver.getDriver().navigate().refresh();
        //room id is dynamic based on the room number so had to adopt the following approach to access the room booking with a specific room number
        String currentRoomId = "roomNumber" + roomNo;
        boolean result;
        try {
            result = SharedDriver.getDriver().findElement(By.id(currentRoomId)).isDisplayed();
        } catch (NoSuchElementException e) {
            result = false;
        }
        return result;
    }
}