package com.co.konex.test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;

import java.util.logging.Logger;

import static com.co.konex.test.userinterfaces.CreateAccWikipediaUI.POPUP;

public class GetTheText implements Question<Boolean> {

    protected String element;
    protected String popUpMessage;

    private static final Logger LOGGER = Logger.getLogger(GetTheText.class.getName());

    public GetTheText(String element, String popUpMessage) {
        this.element = element;
        this.popUpMessage = popUpMessage;
    }

    /**
     * Determines if the pop-up message is displayed as a tooltip on the webpage.
     *
     * @param actor the actor who is performing the action
     * @return true if the pop-up message is displayed as a tooltip, otherwise false
     */
    @Override
    public Boolean answeredBy(Actor actor) {
        String msg = BrowseTheWeb.as(actor).getDriver().findElement(By.xpath(POPUP)).getAttribute("validationMessage");
        LOGGER.info("the tooltip displays: "+msg);
        return msg.contains(popUpMessage);
    }

    public static Question<Boolean> ofPopUp(String element, String popUpMessage){
        return new GetTheText(element, popUpMessage);
    }
}
