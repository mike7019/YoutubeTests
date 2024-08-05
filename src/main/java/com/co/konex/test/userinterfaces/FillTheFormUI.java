package com.co.konex.test.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class FillTheFormUI {

    public static final Target BTN_SIGN_IN = Target.the("button to sign in")
            .locatedBy("(//ytd-button-renderer[@class='style-scope ytd-masthead'])[3]");
    public static final Target BTN_CREATE_ACCOUNT = Target.the("button to create acc")
            .locatedBy("//button//*[contains(text(),'Create account')]");
    public static final Target LST_TYPE_ACC = Target.the("type of account list")
            .locatedBy("//ul[@aria-label='Create account']");
    public static final Target TXT_NAME = Target.the("input for name")
            .locatedBy("//input[@name='firstName']");
    public static final Target TXT_LASTNAME = Target.the("input for lastname")
            .locatedBy("//input[@name='lastName']");
    public static final Target BTN_NEXT = Target.the("button to go next")
            .locatedBy("//button//*[contains(text(),'Next')]");
    public static final Target LST_MONTH = Target.the("month list")
            .locatedBy("//select[@id='month']");
    public static final Target TXT_DAY = Target.the("input for day")
            .locatedBy("//input[@name='day']");
    public static final Target LST_YEAR = Target.the("input for year")
            .locatedBy("//input[@name='year']");
    public static final Target LST_GENDER = Target.the("list for gender")
            .locatedBy("//select[@id='gender']");
    public static final Target BTN_GET_EMAIL = Target.the("link to get a new email")
            .locatedBy("//div//*[contains(text(),'Get a Gmail address instead')]");
    public static final Target RBN_FIRST = Target.the("first radiobutton")
            .locatedBy("(//div[@role='radio'])[1]");
    public static final Target TXT_PASS = Target.the("field for pass")
            .locatedBy("(//input[@type='password'])[1]");
    public static final Target TXT_CONF_PASS = Target.the("field for pass confirmation")
            .locatedBy("(//input[@type='password'])[2]");
    public static final Target TXT_CELLPHONE = Target.the("field for phone")
            .locatedBy("//input[@id='phoneNumberId']");
    public static final Target TXT_ENTER_CODE = Target.the("text to validate on screen")
            .locatedBy("//h1");
}
