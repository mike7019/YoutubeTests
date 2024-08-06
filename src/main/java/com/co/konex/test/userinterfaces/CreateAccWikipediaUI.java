package com.co.konex.test.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CreateAccWikipediaUI {

    public static final Target BTN_CREATE_ACC = Target.the("button to create account")
            .locatedBy("(//a//span[contains(text(),'Crear una cuenta')])[1]");
    public static final Target TXT_USERNAME = Target.the("")
            .locatedBy("//input[@placeholder='Escribe tu nombre de usuario']");
    public static final Target TXT_PASSWORD = Target.the("")
            .locatedBy("//input[@id='wpPassword2']");
    public static final Target TXT_CONF_PASS = Target.the("")
            .locatedBy("//input[@id='wpRetype']");
    public static final Target TXT_EMAIL = Target.the("")
            .locatedBy("//input[@id='wpEmail']");
    public static final Target BTN_SUBMIT = Target.the("")
            .locatedBy("//button[@id='wpCreateaccount']");

    public static final String POPUP = "//input[@id='mw-input-captchaWord']";

}
