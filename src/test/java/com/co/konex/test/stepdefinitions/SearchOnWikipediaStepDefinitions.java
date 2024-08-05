package com.co.konex.test.stepdefinitions;

import com.co.konex.test.questions.ValidateTheTitle;
import com.co.konex.test.tasks.SearchAndScroll;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.co.konex.test.userinterfaces.HeadingWikipediaUI.TXT_ANALYTICS;
import static com.co.konex.test.utils.GlobalData.MIKE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;

public class SearchOnWikipediaStepDefinitions {

    @When("^he searches for (.*) and scrolls down looking for (.*)$")
    public void heSearchesForWordAndScrollsDownLookingForKeyword(String word, String keyword) {
        OnStage.theActorCalled(MIKE).attemptsTo(
                SearchAndScroll.onWikipedia(word, keyword)
        );
    }
    @Then("^will validate the (.*) on screen$")
    public void willValidateTheKeywordOnScreen(String title) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidateTheTitle.on(TXT_ANALYTICS), containsString(title))
        );
    }
}
