package com.co.konex.test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateTheCode implements Question<Boolean> {

    protected Target element;

    public ValidateTheCode(Target element) {
        this.element = element;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return element.resolveFor(actor).isDisplayed();
    }

    public static Question<Boolean> title(Target element){
        return new ValidateTheCode(element);
    }
}
