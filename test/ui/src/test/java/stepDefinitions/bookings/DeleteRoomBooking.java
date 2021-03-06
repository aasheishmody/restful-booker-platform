package stepDefinitions.bookings;

import base.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.BBBookingManagementPage;

import java.util.List;
import java.util.Map;

public class DeleteRoomBooking {

    private final TestContext testContext;

    public DeleteRoomBooking(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("I click the 'x' button for a room booking on the 'B&B Booking management' page")
    public void iClickTheXButtonForARoomBookingOnTheBBBookingManagementPage(DataTable roomNumber) throws Exception {
        List<Map<String, String>> data = roomNumber.asMaps(String.class, String.class);
        testContext.page.GetInstance(BBBookingManagementPage.class).clickXButton(data.get(0).get("Room #"));
        testContext.setScenarioContext("Room #", data.get(0).get("Room #"));
    }

    @Then("the room booking is not displayed on the 'B&B Booking management' page")
    public void theRoomBookingIsNotDisplayedOnTheBBBookingManagementPage(DataTable roomNumber) {
        String roomNo = (String) testContext.getScenarioContext("Room #");
        Assert.assertFalse(testContext.page.GetInstance(BBBookingManagementPage.class).roomBookingIsDisplayed(roomNo));
    }
}
