package com.co.konex.test.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HeadingWikipediaUI {
    public static final Target TXT_HEADER = Target.the("welcome text")
            .locatedBy("//*[contains(text(),'{0}')]");
    public static final Target TXT_SEARCH = Target.the("")
            .locatedBy("//input[@placeholder='Buscar en Wikipedia']");
    public static final Target TXT_ANALYTICS = Target.the("")
            .locatedBy("//div[@class='mw-heading mw-heading3']//*[contains(text(),'CEEM')]");
}
