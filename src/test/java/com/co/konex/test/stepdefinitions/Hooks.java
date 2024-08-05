package com.co.konex.test.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.core.Serenity.getDriver;

public class Hooks {

    /**
     * Sets up the stage for the test scenario.
     * This method is called before each test case to initialize the stage.
     * The stage is set using the OnlineCast class, which allows for online testing of the application.
     */
    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

}
