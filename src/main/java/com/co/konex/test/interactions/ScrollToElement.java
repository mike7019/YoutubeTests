package com.co.konex.test.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import net.serenitybdd.screenplay.actions.ScrollTo;
import net.serenitybdd.screenplay.actions.ScrollToTarget;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.core.Serenity.getDriver;


public class ScrollToElement implements Interaction {

    protected Target element;

    public ScrollToElement(Target element) {
        this.element = element;
    }

    /**
     * This method is used to scroll the web page so that the specified element becomes visible.
     *
     * @param actor the actor performing the action
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement object = element.resolveFor(actor);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", object);

    }

    public static ScrollToElement to(Target element){
        return Instrumented.instanceOf(ScrollToElement.class).withProperties(element);
    }
}
