package net.testiteasy.screens.search;

import net.testiteasy.utils.variables.OSType;

import static com.codeborne.selenide.appium.ScreenObject.screen;
import static net.testiteasy.utils.config.TestProjectConfig.testConfig;

public class SearchScreenObjectFactory {

    public static SearchScreen get() {
        return testConfig().getOSType().equals(OSType.ANDROID) ?
                screen(AndroidSearchScreen.class) :
                screen(IOSSearchScreen.class);
    }
}
