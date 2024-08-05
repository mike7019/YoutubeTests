package com.co.konex.test.tasks;

import com.co.konex.test.interactions.ChooseFromList;
import com.co.konex.test.utils.RamdonNumber;
import com.github.javafaker.Faker;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.co.konex.test.userinterfaces.FillTheFormUI.*;
import static com.co.konex.test.utils.GlobalData.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SignIn implements Interaction {

    protected Faker faker = new Faker();

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_SIGN_IN, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(BTN_SIGN_IN),
                Click.on(BTN_CREATE_ACCOUNT),
                ChooseFromList.on(LST_TYPE_ACC, 0),
                Enter.theValue(faker.name().firstName()).into(TXT_NAME),
                Enter.theValue(faker.name().lastName()).into(TXT_LASTNAME),
                Click.on(BTN_NEXT),
                SelectFromOptions.byIndex(RamdonNumber.months()).from(LST_MONTH),
                Enter.theValue(RamdonNumber.days()).into(TXT_DAY),
                Enter.theValue(RamdonNumber.years()).into(LST_YEAR),
                SelectFromOptions.byIndex(RamdonNumber.gender()).from(LST_GENDER),
                Click.on(BTN_NEXT),
                Click.on(BTN_GET_EMAIL),
                Click.on(RBN_FIRST),
                Click.on(BTN_NEXT),
                Enter.theValue(PASSWORD).into(TXT_PASS),
                Enter.theValue(PASSWORD).into(TXT_CONF_PASS),
                Click.on(BTN_NEXT),
                Enter.theValue(PHONE).into(TXT_CELLPHONE),
                Click.on(BTN_NEXT),
                WaitUntil.the(TXT_ENTER_CODE, isVisible()).forNoMoreThan(10).seconds()
                );
    }

    public static SignIn onTheSite() {
        return Instrumented.instanceOf(SignIn.class).withProperties();
    }
}
