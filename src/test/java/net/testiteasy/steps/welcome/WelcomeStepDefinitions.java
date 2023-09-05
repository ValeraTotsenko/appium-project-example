package net.testiteasy.steps.welcome;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.SupportsRotation;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.testiteasy.drivers.AppiumRemoteDriver;
import net.testiteasy.screens.main.MainScreen;
import net.testiteasy.screens.main.MainScreenObjectFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScreenOrientation;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static net.testiteasy.utils.config.TestProjectConfig.testConfig;

public class WelcomeStepDefinitions {

    private final MainScreen mainScreen = MainScreenObjectFactory.get();

    @When("welcome screen ready")
    public void welcomeScreenReady() {
        mainScreen.waitForMainContainerToAppear();
    }

    @Then("user can see Explore icon")
    public void userCanSeeExploreIcon() {
        mainScreen.checkExploreIcon();
    }

    @When("user tap on the search field")
    public void userTypeInSearchLine() {
        mainScreen.clickOnSearchField();
    }

    @Then("user can see History icon")
    public void userCanSeeHistoryIcon() {
        mainScreen.checkHistoryIcon();
    }

    @When("user click on History icon")
    public void userClickOnHistoryIcon() {
        mainScreen.clickHistoryIcon();
    }

    @When("I rotate device to landscape orientation")
    public void iRotateDeviceToLandscapeOrientation() {
       ((SupportsRotation) getWebDriver()).rotate(ScreenOrientation.LANDSCAPE);

    }

    @When("user scroll to {string} date")
    public void userScrollToDate(String date) {

        switch (testConfig().getOSType()) {
            case ANDROID -> {
                getWebDriver().findElement(MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))." +
                                "scrollIntoView(new UiSelector().text(\"" + date + "\"))"));
            }

            case IOS -> {
                getWebDriver().findElement(MobileBy.iOSClassChain(
                        "new UiScrollable(new UiSelector().scrollable(true))." +
                                "scrollIntoView(new UiSelector().text(\"" + date + "\"))"));
            }
        }
    }

    @Then("search icon is displayed")
    public void searchIconIsDisplayed() {
        mainScreen.isSearchIconDisplayed();
    }
}
