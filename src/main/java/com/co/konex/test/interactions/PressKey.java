package com.co.konex.test.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static net.serenitybdd.core.Serenity.getDriver;

public class PressKey implements Interaction {

    protected Keys key;

    public PressKey(Keys key) {
        this.key = key;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Actions action = new Actions(getDriver());
        action.sendKeys(key).build().perform();
    }

    public static PressKey on(Keys key){
        return Instrumented.instanceOf(PressKey.class).withProperties(key);
    }
}
