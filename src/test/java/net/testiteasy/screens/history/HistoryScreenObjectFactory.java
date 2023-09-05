package net.testiteasy.screens.history;

import net.testiteasy.screens.main.AndroidMainScreen;
import net.testiteasy.screens.main.IOSMainScreen;
import net.testiteasy.screens.main.MainScreen;
import net.testiteasy.utils.variables.OSType;

import static com.codeborne.selenide.appium.ScreenObject.screen;
import static net.testiteasy.utils.config.TestProjectConfig.testConfig;

public class HistoryScreenObjectFactory {

	public static HistoryScreen get() {
		return testConfig().getOSType().equals(OSType.ANDROID) ?
				screen(AndroidHistoryScreen.class) :
				screen(IOSHistoryScreen.class);
	}
}
