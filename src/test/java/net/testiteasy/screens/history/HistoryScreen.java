package net.testiteasy.screens.history;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HistoryScreen {

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")
	private SelenideElement SCREEN_TITLE;

	public String getScreenTitle() {
		return SCREEN_TITLE.shouldBe(Condition.visible).text();
	}
}
