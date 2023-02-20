package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.TechGlobalBasePage;
import pages.TechGlobalFrontendPage;
import pages.TechGlobalPaginationPage;
import utilities.Driver;

public class TechGlobalSteps {
    WebDriver driver;
    Actions actions;
    TechGlobalBasePage techGlobalBasePage;
    TechGlobalFrontendPage techGlobalFrontendPage;
    TechGlobalPaginationPage techGlobalPaginationPage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        actions = new Actions(driver);
        techGlobalBasePage = new TechGlobalBasePage();
        techGlobalFrontendPage = new TechGlobalFrontendPage();
        techGlobalPaginationPage = new TechGlobalPaginationPage();
    }

    @Given("user is on {string}")
    public void userIsOn(String url) {
        driver.get(url);
    }

    @When("user moves to {string}header dropdown")
    public void userMovesToHeaderDropdown(String headerDropdown) {
        actions.moveToElement(techGlobalBasePage.headerDropdown).perform();
    }

    @And("user clicks on {string}header dropdown option")
    public void userClicksOnHeaderDropdownOption(String option) {
        techGlobalBasePage.selectByVisibleText(option);
    }

    @Then("user should be navigated to {string}")
    public void userShouldBeNavigatedTo(String pageURL) {
        Assert.assertEquals(driver.getCurrentUrl(), pageURL);
    }

    @And("user clicks on {string}card")
    public void userClicksOnCard(String cardName) {
        techGlobalFrontendPage.clickOnCard(cardName);
    }

    @And("user should see {string}heading")
    public void userShouldSeeHeading(String headingText) {
        switch (headingText) {
            case "Pagination":
                Assert.assertEquals(headingText, techGlobalPaginationPage.mainHeading.getText());
                break;
            case "World City Populations 2022":
                Assert.assertEquals(headingText, techGlobalPaginationPage.subHeading.getText());
                break;
            default:
                throw new NotFoundException("The heading text was not found!");
        }
    }

    @And("user should see {string}paragraph")
    public void userShouldSeeParagraph(String paragraphText) {
        Assert.assertEquals(paragraphText, techGlobalPaginationPage.pageContent.getText());
    }

    @And("user should see “Previous” button is disabled")
    public void userShouldSeePreviousButtonIsDisabled() {
        Assert.assertFalse(techGlobalPaginationPage.btnPrevious.isEnabled());
    }

    @And("user should see “Next” button is enabled")
    public void userShouldSeeNextButtonIsEnabled() {
        Assert.assertTrue(techGlobalPaginationPage.btnNext.isEnabled());
    }

    @When("user clicks on “Next” button")
    public void userClicksOnNextButton() {
        techGlobalPaginationPage.btnNext.click();
    }

    @Then("user should see “Previous” button is enabled")
    public void userShouldSeePreviousButtonIsEnabled() {
        Assert.assertTrue(techGlobalPaginationPage.btnPrevious.isEnabled());
    }

    @When("user clicks on “Next” button till it becomes disabled")
    public void userClicksOnNextButtonTillItBecomesDisabled() {
        while (techGlobalPaginationPage.btnNext.isEnabled()) {
            techGlobalPaginationPage.btnNext.click();
        }
    }

    @And("user should see “Next” button is disabled")
    public void userShouldSeeNextButtonIsDisabled() {
        Assert.assertFalse(techGlobalPaginationPage.btnNext.isEnabled());
    }

    @And("user should see city with info below and an image")
    public void userShouldSeeCityWithInfoBelowAndAnImage(DataTable data) {
        for(int i = 0; i < data.asList().size(); i++) {
            Assert.assertEquals(data.asList().get(i), techGlobalPaginationPage.cityDetailList.get(i).getText());
        }
        Assert.assertTrue(techGlobalPaginationPage.cityImage.isDisplayed());
        techGlobalPaginationPage.btnNext.click();
    }

//    @And("user should see “Tokyo” city with info below and an image")
//    public void userShouldSeeTokyoCityWithInfoBelowAndAnImage(DataTable cityInfo) {
//        for(int i = 0; i < cityInfo.asList().size(); i++) {
//            Assert.assertEquals(cityInfo.asList().get(i), techGlobalPaginationPage.cityDetailList.get(i).getText());
//        }
//        Assert.assertTrue(techGlobalPaginationPage.cityImage.isDisplayed());
//        techGlobalPaginationPage.btnNext.click();
//    }
//
//    @And("user should see “Delhi” city with info below and an image")
//    public void userShouldSeeDelhiCityWithInfoBelowAndAnImage(DataTable cityInfo) {
//        for(int i = 0; i < cityInfo.asList().size(); i++) {
//            Assert.assertEquals(cityInfo.asList().get(i), techGlobalPaginationPage.cityDetailList.get(i).getText());
//        }
//        Assert.assertTrue(techGlobalPaginationPage.cityImage.isDisplayed());
//        techGlobalPaginationPage.btnNext.click();
//    }
//
//    @And("user should see “Shangai” city with info below and an image")
//    public void userShouldSeeShangaiCityWithInfoBelowAndAnImage(DataTable cityInfo) {
//        for(int i = 0; i < cityInfo.asList().size(); i++) {
//            Assert.assertEquals(cityInfo.asList().get(i), techGlobalPaginationPage.cityDetailList.get(i).getText());
//        }
//        Assert.assertTrue(techGlobalPaginationPage.cityImage.isDisplayed());
//        techGlobalPaginationPage.btnNext.click();
//    }
//
//    @And("user should see “Sao Paulo” city with info below and an image")
//    public void userShouldSeeSaoPauloCityWithInfoBelowAndAnImage(DataTable cityInfo) {
//        for(int i = 0; i < cityInfo.asList().size(); i++) {
//            Assert.assertEquals(cityInfo.asList().get(i), techGlobalPaginationPage.cityDetailList.get(i).getText());
//        }
//        Assert.assertTrue(techGlobalPaginationPage.cityImage.isDisplayed());
//        techGlobalPaginationPage.btnNext.click();
//    }
//
//    @And("user should see “Mexico City” city with info below and an image")
//    public void userShouldSeeMexicoCityCityWithInfoBelowAndAnImage(DataTable cityInfo) {
//        for(int i = 0; i < cityInfo.asList().size(); i++) {
//            Assert.assertEquals(cityInfo.asList().get(i), techGlobalPaginationPage.cityDetailList.get(i).getText());
//        }
//        Assert.assertTrue(techGlobalPaginationPage.cityImage.isDisplayed());
//        techGlobalPaginationPage.btnNext.click();
//    }
}
