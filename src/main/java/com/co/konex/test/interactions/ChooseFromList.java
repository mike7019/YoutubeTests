package com.co.konex.test.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ChooseFromList implements Interaction {

    protected Target lstTypeAcc;
    protected int index;

    public ChooseFromList(Target lstTypeAcc, int index) {
        this.lstTypeAcc = lstTypeAcc;
        this.index = index;
    }

    /**
     * Performs the action of choosing an option from a ul/li list.
     *
     * @param actor the actor performing the action
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElement> options = lstTypeAcc.resolveFor(actor).findElements(By.tagName("li"));
        options.get(index).click();
    }

    public static ChooseFromList on(Target lstTypeAcc, int index) {
        return Instrumented.instanceOf(ChooseFromList.class).withProperties(lstTypeAcc, index);
    }
}
