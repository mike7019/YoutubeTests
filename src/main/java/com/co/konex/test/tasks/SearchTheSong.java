package com.co.konex.test.tasks;

import com.co.konex.test.interactions.ChooseFromSongs;
import com.co.konex.test.interactions.PressKey;
import com.co.konex.test.models.SearchOnYoutubeModel;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static com.co.konex.test.userinterfaces.SearchOnYoutubeUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchTheSong implements Task {

    /**
     * The SearchOnYoutubeModel variable is an object that represents the search criteria for searching songs on Youtube. It is used in the SearchTheSong class to perform a search
     *  on Youtube.
     * @see SearchTheSong
     * @see PressKey
     */
    protected SearchOnYoutubeModel searchOnYoutubeModel;

    public SearchTheSong(SearchOnYoutubeModel searchOnYoutubeModel) {
        this.searchOnYoutubeModel = searchOnYoutubeModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TXT_SEARCH, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(searchOnYoutubeModel.getSong()).into(TXT_SEARCH),
                PressKey.on(Keys.ENTER),
                WaitUntil.the(TXT_SONGS, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(TXT_SONGS),
                PressKey.on(Keys.TAB),
                PressKey.on(Keys.ENTER),
                WaitUntil.the(TXT_TITLE, isVisible()).forNoMoreThan(20).seconds()
        );
    }

    public static SearchTheSong onYoutube(SearchOnYoutubeModel searchOnYoutubeModel) {
        return Instrumented.instanceOf(SearchTheSong.class).withProperties(searchOnYoutubeModel);
    }
}
