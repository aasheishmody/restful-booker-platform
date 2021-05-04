package stepDefinitions.bookings;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AdminPanelPage;
import pages.BBBookingManagementPage;

import java.util.List;
import java.util.Map;

public class Bookings {

    private final AdminPanelPage adminPanelPage;
    private final BBBookingManagementPage bbBookingManagementPage;

    public Bookings(AdminPanelPage adminPanelPage, BBBookingManagementPage bbBookingManagementPage) {
        this.adminPanelPage = adminPanelPage;
        this.bbBookingManagementPage = bbBookingManagementPage;
    }

    @Given("I am on the 'B&B Booking management' page as a logged in user")
    public void iAmOnTheBBBookingManagementPageAsALoggedInUser(DataTable userCreds) {
        adminPanelPage.navigateToAdminPage();
        Assert.assertTrue(adminPanelPage.iAMOnTheAdminPanelPage());
        List<Map<String, String>> data = userCreds.asMaps(String.class, String.class);
        //TODO Improvement - Mask the password
        adminPanelPage.login(data.get(0).get("Username"), data.get(0).get("Password"));
        Assert.assertTrue(bbBookingManagementPage.iAmOnTheBBBookingManagementPage());
    }

    @When("I enter the booking details on the 'B&B Booking management' page to add a new booking")
    public void iEnterTheBookingDetailsOnTheBBBookingManagementPageToAddANewBooking(DataTable bookingDetails) {
        List<Map<String, String>> data = bookingDetails.asMaps(String.class, String.class);
        // TODO - Improve with generics
        bbBookingManagementPage.enterRoomBookingDetails(data.get(0).get("Room #"),data.get(0).get("Type"),data.get(0).get("Accessible"),data.get(0).get("Price"),data.get(0).get("WiFi"),data.get(0).get("TV"),data.get(0).get("Radio"),data.get(0).get("Refreshments"),data.get(0).get("Safe"),data.get(0).get("Views"));
    }

    @And("I click the 'Create' button on the 'B&B Booking management' page")
    public void iClickTheCreateButtonOnTheBBBookingManagementPage() {
        bbBookingManagementPage.clickCreateButton();
    }

    @Then("the new room booking is displayed on the 'B&B Booking management' page")
    public void theNewRoomBookingIsDisplayedOnTheBBBookingManagementPage(DataTable bookingDetails) {
        //Assert.assertTrue(bbBookingManagementPage.newRoomBookingIsDisplayed());
    }
}
