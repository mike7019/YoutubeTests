package com.co.konex.test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateTheCode implements Question<Boolean> {

    protected Target element;

    public ValidateTheCode(Target element) {
        this.element = element;
    }

    /**
     * Checks if the given element is displayed on the user interface
     *
     * @param actor the actor who will perform the verification
     * @return true if the element is displayed, false otherwise
     */
    @Override
    public Boolean answeredBy(Actor actor) {
        return element.resolveFor(actor).isDisplayed();
    }

    public static Question<Boolean> title(Target element){
        return new ValidateTheCode(element);
    }
}
