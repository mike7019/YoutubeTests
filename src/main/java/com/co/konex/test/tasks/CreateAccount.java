package com.co.konex.test.tasks;

import com.github.javafaker.Faker;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.co.konex.test.userinterfaces.CreateAccWikipediaUI.*;
import static com.co.konex.test.utils.GlobalData.PASSWORD;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CreateAccount implements Task {


    protected Faker faker = new Faker();

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_CREATE_ACC, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_CREATE_ACC),
                Enter.theValue(faker.name().name()).into(TXT_USERNAME),
                Enter.theValue(PASSWORD).into(TXT_PASSWORD),
                Enter.theValue(PASSWORD).into(TXT_CONF_PASS),
                Enter.theValue(faker.name().firstName()+"@gmail.com").into(TXT_EMAIL),
                Click.on(BTN_SUBMIT)
        );
    }

    public static CreateAccount onWikipedia(){
        return Instrumented.instanceOf(CreateAccount.class).withProperties();
    }
}
