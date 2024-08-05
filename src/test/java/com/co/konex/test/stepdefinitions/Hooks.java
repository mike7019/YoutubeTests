package com.co.konex.test.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.core.Serenity.getDriver;

public class Hooks {

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

}
