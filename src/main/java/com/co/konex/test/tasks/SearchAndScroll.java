package com.co.konex.test.tasks;

import com.co.konex.test.interactions.PressKey;
import com.co.konex.test.interactions.ScrollToElement;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static com.co.konex.test.userinterfaces.HeadingWikipediaUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchAndScroll implements Task {


    protected String word;
    protected String keyword;


    public SearchAndScroll(String word, String keyword) {
        this.word = word;
        this.keyword = keyword;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TXT_SEARCH, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(word).into(TXT_SEARCH),
                PressKey.on(Keys.ENTER),
                WaitUntil.the(TXT_ANALYTICS, isVisible()).forNoMoreThan(20).seconds(),
                ScrollToElement.to(TXT_ANALYTICS),
                Ensure.that(TXT_ANALYTICS).hasText(keyword)
        );
    }

    public static SearchAndScroll onWikipedia(String word, String keyword) {
        return Instrumented.instanceOf(SearchAndScroll.class).withProperties(word, keyword);
    }
}
