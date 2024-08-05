package com.co.konex.test.stepdefinitions;


import com.co.konex.test.models.SearchOnYoutubeModel;
import com.co.konex.test.questions.ValidateTheTitle;
import com.co.konex.test.tasks.SearchTheSong;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.co.konex.test.userinterfaces.SearchOnYoutubeUI.TXT_TITLE;
import static com.co.konex.test.utils.GlobalData.MIKE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class SearchOnYoutubeStepDefinitions {

    @Given("^Mike was on the (.*)$")
    public void mikeWasOnsite(String site) {
        OnStage.theActorCalled(MIKE).wasAbleTo(Open.url(site));
    }

    @When("He searches for the song to listen")
    public void heSearchesForThesong(DataTable table) {
        OnStage.theActorCalled(MIKE).attemptsTo(
                SearchTheSong.onYoutube(SearchOnYoutubeModel.setData(table).get(0))
        );
    }

    @Then("^validates that the (.*) is contained within the site$")
    public void validatesThatTheSongIsContainedWithinTheSite(String song) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidateTheTitle.on(TXT_TITLE), containsString(song))
        );
    }

}
