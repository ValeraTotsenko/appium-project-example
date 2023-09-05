package net.testiteasy.steps.history;

import io.cucumber.java.en.Then;
import net.testiteasy.screens.history.HistoryScreen;
import net.testiteasy.screens.history.HistoryScreenObjectFactory;
import org.junit.jupiter.api.Assertions;

public class HistoryStepDefenitions {

	private final HistoryScreen historyScreen = HistoryScreenObjectFactory.get();

	@Then("{string} is displayed on tab title")
	public void isDisplayedOnTabTitle(String title) {
		Assertions.assertEquals(title, historyScreen.getScreenTitle(),
				"Title is not equals to expected");
	}
}
