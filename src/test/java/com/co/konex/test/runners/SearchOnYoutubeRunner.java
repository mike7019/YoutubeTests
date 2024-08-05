package com.co.konex.test.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/searchOnYoutube.feature",
        glue = "com.co.konex.test.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class SearchOnYoutubeRunner {
}
