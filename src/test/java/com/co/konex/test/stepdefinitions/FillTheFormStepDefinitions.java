package com.co.konex.test.stepdefinitions;

import com.co.konex.test.questions.ValidateTheCode;
import com.co.konex.test.tasks.SignIn;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.co.konex.test.userinterfaces.FillTheFormUI.TXT_ENTER_CODE;
import static com.co.konex.test.utils.GlobalData.MIKE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class FillTheFormStepDefinitions {

    @When("He attemps to sign in")
    public void heAttempsToSignIn() {
        OnStage.theActorCalled(MIKE).attemptsTo(
                SignIn.onTheSite()
        );
    }

    @Then("will see the code request message on screen")
    public void willSeeTheCodeRequestMessageOnScreen() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidateTheCode.title(TXT_ENTER_CODE))
        );
    }
}
