package com.co.konex.test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateTheTitle implements Question<String> {

    protected Target element;

    public ValidateTheTitle(Target element) {
        this.element = element;
    }

    /**
     * Returns the text of the element resolved for the given actor.
     *
     * @param actor the actor that performs the action
     * @return the text of the element resolved for the actor
     */
    @Override
    public String answeredBy(Actor actor) {
        return element.resolveFor(actor).getText();
    }

    /**
     * Returns a question that validates the title of an element.
     *
     * @param element the target element to validate
     * @return a Question object that validates the title of the element
     */
    public static Question<String> on(Target element){
        return new ValidateTheTitle(element);
    }
}
