package com.co.konex.test.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class SearchOnYoutubeUI {


    public static final Target TXT_SEARCH = Target.the("search box")
            .locatedBy("//input[@id='search']");
    public static final Target TXT_SONGS = Target.the("lists of songs")
            .locatedBy("//div[@id='dismissible' and @class='style-scope ytd-video-renderer']");
    public static final Target TXT_SONG = Target.the("the wanted song")
            .locatedBy("");
    public static final Target TXT_TITLE = Target.the("the title of the song")
            .locatedBy("//h1[@class='style-scope ytd-watch-metadata']");
    public static final String XPATH_SONGS ="//div[@id='dismissible' and @class='style-scope ytd-video-renderer']";

}
