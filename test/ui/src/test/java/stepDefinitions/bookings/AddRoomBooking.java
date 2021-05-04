package stepDefinitions.bookings;

import base.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AdminPanelPage;
import pages.BBBookingManagementPage;

import java.util.List;
import java.util.Map;

public class AddRoomBooking {

    private final TestContext testContext;

    public AddRoomBooking(TestContext testContext) {
        this.testContext=testContext;
    }

    @Given("I am on the 'B&B Booking management' page as a logged in user")
    public void iAmOnTheBBBookingManagementPageAsALoggedInUser(DataTable userCreds) {
        testContext.page.GetInstance(AdminPanelPage.class).navigateToAdminPage();
        Assert.assertTrue(testContext.page.GetInstance(AdminPanelPage.class).iAMOnTheAdminPanelPage());
        List<Map<String, String>> data = userCreds.asMaps(String.class, String.class);
        //TODO Improvement - Mask the password
        testContext.page.GetInstance(AdminPanelPage.class).login(data.get(0).get("Username"), data.get(0).get("Password"));
        Assert.assertTrue(testContext.page.GetInstance(BBBookingManagementPage.class).iAmOnTheBBBookingManagementPage());
    }

    @When("I enter the booking details on the 'B&B Booking management' page to add a new booking")
    public void iEnterTheBookingDetailsOnTheBBBookingManagementPageToAddANewBooking(DataTable bookingDetails) throws Exception {
        List<Map<String, String>> data = bookingDetails.asMaps(String.class, String.class);
        // TODO - Improve with generics
        testContext.page.GetInstance(BBBookingManagementPage.class).enterRoomBookingDetails(data.get(0).get("Room #"),data.get(0).get("Type"),data.get(0).get("Accessible"),data.get(0).get("Price"),data.get(0).get("WiFi"),data.get(0).get("TV"),data.get(0).get("Radio"),data.get(0).get("Refreshments"),data.get(0).get("Safe"),data.get(0).get("Views"));
        // TODO - Improve with pojo and lombok
        testContext.setScenarioContext("Room #", data.get(0).get("Room #"));
        testContext.setScenarioContext("Type", data.get(0).get("Type"));
        testContext.setScenarioContext("Accessible", data.get(0).get("Accessible"));
        testContext.setScenarioContext("Price", data.get(0).get("Price"));
        testContext.setScenarioContext("WiFi", data.get(0).get("WiFi"));
        testContext.setScenarioContext("TV", data.get(0).get("TV"));
        testContext.setScenarioContext("Radio", data.get(0).get("Radio"));
        testContext.setScenarioContext("Refreshments", data.get(0).get("Refreshments"));
        testContext.setScenarioContext("Safe", data.get(0).get("Safe"));
        testContext.setScenarioContext("Views", data.get(0).get("Views"));
    }

    @And("I click the 'Create' button on the 'B&B Booking management' page")
    public void iClickTheCreateButtonOnTheBBBookingManagementPage() {
        testContext.page.GetInstance(BBBookingManagementPage.class).clickCreateButton();
    }

    @Then("the new room booking is displayed on the 'B&B Booking management' page")
    public void theNewRoomBookingIsDisplayedOnTheBBBookingManagementPage(DataTable bookingDetails) {
        String roomNumber = (String) testContext.getScenarioContext("Room #");
        String roomType = (String) testContext.getScenarioContext("Type");
        String accessible = (String) testContext.getScenarioContext("Accessible");
        String price = (String) testContext.getScenarioContext("Price");
        String wifi = (String) testContext.getScenarioContext("WiFi");
        String tv = (String) testContext.getScenarioContext("TV");
        String radio = (String) testContext.getScenarioContext("Radio");
        String refreshments = (String) testContext.getScenarioContext("Refreshments");
        String safe = (String) testContext.getScenarioContext("Safe");
        String views = (String) testContext.getScenarioContext("Views");
        Assert.assertTrue(testContext.page.GetInstance(BBBookingManagementPage.class).newRoomBookingIsDisplayed(roomNumber, roomType, accessible, price, wifi, tv, radio, refreshments, safe, views));
    }
}
