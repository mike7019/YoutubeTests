package com.co.konex.test.stepdefinitions;

import com.co.konex.test.questions.GetTheText;
import com.co.konex.test.tasks.CreateAccount;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.co.konex.test.userinterfaces.CreateAccWikipediaUI.POPUP;
import static com.co.konex.test.utils.GlobalData.MIKE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CreateAccWikipediaStepDefinitions {

    @When("he attempts to create the account")
    public void heAttemptsToCreateTheAccount() {
        OnStage.theActorCalled(MIKE).attemptsTo(
                CreateAccount.onWikipedia()
        );
    }
    @Then("^will validate the captcha popup with (.*)$")
    public void willValidateTheCaptchaPopupWithMessage(String message) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(GetTheText.ofPopUp(POPUP, message))
        );
    }
}
