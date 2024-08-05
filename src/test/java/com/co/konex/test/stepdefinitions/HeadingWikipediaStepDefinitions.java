package com.co.konex.test.stepdefinitions;

import com.co.konex.test.questions.ValidateTheTitle;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.targets.Target;

import static com.co.konex.test.userinterfaces.HeadingWikipediaUI.TXT_HEADER;
import static com.co.konex.test.utils.GlobalData.MIKE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class HeadingWikipediaStepDefinitions {

    @Then("^will see welcome (.*) on screen$")
    public void willSeeWelcomeMessageOnScreen(String title) {
        OnStage.theActorCalled(MIKE).should(
                seeThat(ValidateTheTitle.on(TXT_HEADER.of(title)), containsString(title))
        );
    }

}
