package com.co.konex.test.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static com.co.konex.test.userinterfaces.SearchOnYoutubeUI.XPATH_SONGS;
import static net.serenitybdd.core.Serenity.getDriver;

public class ChooseFromSongs implements Interaction {

    protected Target element;

    public ChooseFromSongs(Target element) {
        this.element = element;
    }

    /**
     * Performs the click action on the given actor.
     *
     * @param actor the actor to perform the action on
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", XPATH_SONGS);

    }

    public static ChooseFromSongs on(Target element){
        return Instrumented.instanceOf(ChooseFromSongs.class).withProperties(element);
    }
}
