package net.testiteasy.steps;

import com.codeborne.selenide.logevents.SimpleReport;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import net.testiteasy.configuration.SelenideMobileAppiumDriverProvider;
import org.jetbrains.annotations.NotNull;

import static com.codeborne.selenide.Selenide.open;

public class BaseStepDefinitions {

    private final SimpleReport report = new SimpleReport();
    private final SelenideMobileAppiumDriverProvider driverProvider = new SelenideMobileAppiumDriverProvider();

    @Before
    public void cucumberBeforeEachScenario(@NotNull Scenario scenario) {
        scenario.log("Starting Wikipedia Tests with " + scenario.getName());
        report.start();

        driverProvider.appiumServerSetup();
        driverProvider.mobileDriverSetup();
    }

    @Given("^user open application$")
    public void userOpenApplication() {
        open();
    }

    @After
    public void cucumberAfterEachScenario(@NotNull Scenario scenario) {
        scenario.log("Finished Wikipedia Tests with " + scenario.getName());

        driverProvider.closeDriver();

        report.finish(scenario.getName());
    }

}
