# Testing Youtube & Wikipedia


Executes automation on the site [Youtube](https://www.youtube.com/) and and [Wikipedia](https://es.wikipedia.org/wiki/Wikipedia:Portada)




## tools used on the project
<table>
<tr>
  <th>Java 11</th>
  <td>
    <h6>requires Java 11 to run properly, if the JDK is higher it needs to be refactored</h6>
  </td>
</tr>
<tr>
  <th>Gradle 8.0.</th>
  <td>
    <h6>Gradle or Maven is used to manage all dependencies</h6>
  </td>
</tr>
<tr>
  <th>Cucumber 3.9.8</th>
  <td>
    <h6>the automation tool to handle the .feature files with the Gherkin sintax</h6>
  </td>
</tr>
<tr>
  <th>WebDriverManager 5.9.0</th>
  <td>
    <h6>the WebDriverManager for handling the appropiated WebDriver and may be set up on buildGradle file</h6>
  </td>
</tr>


</table>




## Code Structure

the code was developed using screenplay pattern as below:
<table>
<tr>
  <th>Tasks</th>
  <td>
    <h6>Contains all the task to execute on the automation</h6>
  </td>
</tr>
  <tr>
  <th>Interactions</th>
  <td>
    <h6>Contains all the interactions to execute on the automation</h6>
  </td>
</tr>
  <tr>
  <th>Models</th>
  <td>
    <h6>Contains all the models to build the execution data</h6>
  </td>
</tr>
  <tr>
  <th>Uis</th>
  <td>
    <h6>contains all the abstraction classes with the selectors for each site</h6>
  </td>
</tr>
  <tr>
  <th>Drivers</th>
  <td>
    <h6>contains all the drivers for each browser</h6>
  </td>
</tr>
  <tr>
  <th>Runners</th>
  <td>
    <h6>Contains all the runers to run the automation</h6>
  </td>
</tr>
  <tr>
  <th>Steps Definitions</th>
  <td>
    <h6>Contains all the step definitions for each test</h6>
  </td>
</tr>
  <tr>
  <th>Features</th>
  <td>
    <h6>Contains all the scenarios under the Gherkin language</h6>
  </td>
</tr>
<tr>
  <th>Questions</th>
  <td>
    <h6>Contains all the validations needed to ensure the tests</h6>
  </td>
</tr>
</table>


#### Tasks

#### SearchTheSong.java

These task performs a song search in order to test the search bar and validate the title

```java
public class SearchTheSong implements Task {

    /**
     * The SearchOnYoutubeModel variable is an object that represents the search criteria for searching songs on Youtube. It is used in the SearchTheSong class to perform a search
     *  on Youtube.
     * @see SearchTheSong
     * @see PressKey
     */
    protected SearchOnYoutubeModel searchOnYoutubeModel;

    public SearchTheSong(SearchOnYoutubeModel searchOnYoutubeModel) {
        this.searchOnYoutubeModel = searchOnYoutubeModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TXT_SEARCH, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(searchOnYoutubeModel.getSong()).into(TXT_SEARCH),
                PressKey.on(Keys.ENTER),
                WaitUntil.the(TXT_SONGS, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(TXT_SONGS),
                PressKey.on(Keys.TAB),
                PressKey.on(Keys.ENTER),
                WaitUntil.the(TXT_TITLE, isVisible()).forNoMoreThan(20).seconds()
        );
    }

    public static SearchTheSong onYoutube(SearchOnYoutubeModel searchOnYoutubeModel) {
        return Instrumented.instanceOf(SearchTheSong.class).withProperties(searchOnYoutubeModel);
    }
}
```

#### SignIn.java

These class performs a signing in process over youtube through Google

```java
public class SignIn implements Interaction {

    /**
     * This variable is an instance of the Faker class that is used to generate fake data for testing purposes.
     */
    protected Faker faker = new Faker();

    /**
     * Performs the sign up process on the site.
     *
     * @param actor the actor performing the sign up process
     */
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

    /**
     * This method returns an instance of the SignIn class as an Instrumented object with properties.
     *
     * @return An instance of the SignIn class as an Instrumented object with properties.
     */
    public static SignIn onTheSite() {
        return Instrumented.instanceOf(SignIn.class).withProperties();
    }
}
```

#### SearchAndScroll

These class perform the task of searching a keyword and scrolling down til find the key given to validate
```java
public class SearchAndScroll implements Task {


    protected String word;
    protected String keyword;


    public SearchAndScroll(String word, String keyword) {
        this.word = word;
        this.keyword = keyword;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TXT_SEARCH, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(word).into(TXT_SEARCH),
                PressKey.on(Keys.ENTER),
                WaitUntil.the(TXT_ANALYTICS, isVisible()).forNoMoreThan(20).seconds(),
                ScrollToElement.to(TXT_ANALYTICS),
                Ensure.that(TXT_ANALYTICS).hasText(keyword)
        );
    }

    public static SearchAndScroll onWikipedia(String word, String keyword) {
        return Instrumented.instanceOf(SearchAndScroll.class).withProperties(word, keyword);
    }
}
```

### Interactions

#### ChooseFromList

Receives two params, the target element plus the index of the list that is needed to select from
```java
public class ChooseFromList implements Interaction {

    protected Target lstTypeAcc;
    protected int index;

    public ChooseFromList(Target lstTypeAcc, int index) {
        this.lstTypeAcc = lstTypeAcc;
        this.index = index;
    }

    /**
     * Performs the action of choosing an option from a ul/li list.
     *
     * @param actor the actor performing the action
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElement> options = lstTypeAcc.resolveFor(actor).findElements(By.tagName("li"));
        options.get(index).click();
    }

    public static ChooseFromList on(Target lstTypeAcc, int index) {
        return Instrumented.instanceOf(ChooseFromList.class).withProperties(lstTypeAcc, index);
    }
}
```

#### ChooseFromSong.java

this class performs a JavaScriptExecutor instance in order to do a Click over an xpath
```java
public class ChooseFromSongs implements Interaction {

    protected Target element;

    public ChooseFromSongs(Target element) {
        this.element = element;
    }

    /**
     * Performs the click action on the given actor.
     *
     * @param actor the actor to perform the action on
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", XPATH_SONGS);

    }

    public static ChooseFromSongs on(Target element){
        return Instrumented.instanceOf(ChooseFromSongs.class).withProperties(element);
    }
}
```

### PressKey.java

this class allows to press any key listed on the Keys class.

```java
public class PressKey implements Interaction {

    /**
     * The `key` variable represents a key used for interaction in the PressKey class.
     */
    protected Keys key;

    public PressKey(Keys key) {
        this.key = key;
    }

    /**
     * Performs a key press action for the given actor.
     *
     * @param actor the actor who performs the action
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        Actions action = new Actions(getDriver());
        action.sendKeys(key).build().perform();
    }

    public static PressKey on(Keys key){
        return Instrumented.instanceOf(PressKey.class).withProperties(key);
    }
}
```

### ScrollToElement.java

this class uses the WebElement interface to convert the Target to a WebElement element to interact then with JavaScriptExecutor instance.

```java
public class ScrollToElement implements Interaction {

    protected Target element;

    public ScrollToElement(Target element) {
        this.element = element;
    }

    /**
     * This method is used to scroll the web page so that the specified element becomes visible.
     *
     * @param actor the actor performing the action
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement object = element.resolveFor(actor);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", object);

    }

    public static ScrollToElement to(Target element){
        return Instrumented.instanceOf(ScrollToElement.class).withProperties(element);
    }
}
```



#### UserInterfaces

#### SearchOnYoutubeUI.java

locators using xpath
```java
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
```

#### FillTheFormUI.java

locators using xpath
```java
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
```

#### HeadingWikipedia.java

locators using xpath
```java
public class HeadingWikipediaUI {
    public static final Target TXT_HEADER = Target.the("welcome text")
            .locatedBy("//*[contains(text(),'{0}')]");
    public static final Target TXT_SEARCH = Target.the("")
            .locatedBy("//input[@placeholder='Buscar en Wikipedia']");
    public static final Target TXT_ANALYTICS = Target.the("")
            .locatedBy("//div[@class='mw-heading mw-heading3']//*[contains(text(),'CEEM')]");
}
```

#### Questions

#### ValidateTheCode

This Question works with boolean types, so if the elements shows up will return true otherwise false will thrown
```java
public class ValidateTheCode implements Question<Boolean> {

    protected Target element;

    public ValidateTheCode(Target element) {
        this.element = element;
    }

    /**
     * Checks if the given element is displayed on the user interface
     *
     * @param actor the actor who will perform the verification
     * @return true if the element is displayed, false otherwise
     */
    @Override
    public Boolean answeredBy(Actor actor) {
        return element.resolveFor(actor).isDisplayed();
    }

    public static Question<Boolean> title(Target element){
        return new ValidateTheCode(element);
    }
}
```

#### ValidateTheTitle

This Question works with string types, so the text will be extracted and return it to the class ready to being compared in the seeThat() method

```java
public class ValidateTheTitle implements Question<String> {

    protected Target element;

    public ValidateTheTitle(Target element) {
        this.element = element;
    }

    /**
     * Returns the text of the element resolved for the given actor.
     *
     * @param actor the actor that performs the action
     * @return the text of the element resolved for the actor
     */
    @Override
    public String answeredBy(Actor actor) {
        return element.resolveFor(actor).getText();
    }

    /**
     * Returns a question that validates the title of an element.
     *
     * @param element the target element to validate
     * @return a Question object that validates the title of the element
     */
    public static Question<String> on(Target element){
        return new ValidateTheTitle(element);
    }
}
```


#### buildGradle

```groovy
group 'Konex'
version '1.0'

apply plugin: 'java'
apply plugin: 'groovy'
apply plugin: 'java-library'
apply plugin: "net.serenity-bdd.serenity-gradle-plugin"

def versionSerenity='3.9.8'
def versionCucumber='3.9.8'
def versionApachePoi='5.2.2'

repositories {
    mavenCentral()
}

buildscript {
    repositories {
        maven {
            url "https://plugins.gradle.org/m2/"
        }
    }
    dependencies {
        classpath "net.serenity-bdd:serenity-gradle-plugin:3.9.8"
    }
}

dependencies {

    implementation "net.serenity-bdd:serenity-core:${versionSerenity}"
    implementation "net.serenity-bdd:serenity-junit:${versionSerenity}"
    implementation "net.serenity-bdd:serenity-ensure:${versionSerenity}"
    implementation "net.serenity-bdd:serenity-cucumber:${versionCucumber}"
    implementation "net.serenity-bdd:serenity-screenplay:${versionSerenity}"
    implementation "net.serenity-bdd:serenity-report-resources:${versionSerenity}"
    implementation "net.serenity-bdd:serenity-screenplay-webdriver:${versionSerenity}"

    implementation "org.apache.poi:poi:${versionApachePoi}"
    implementation "io.cucumber:datatable:${versionCucumber}"
    implementation "org.apache.poi:poi-ooxml:${versionApachePoi}"
    testImplementation "io.cucumber:cucumber-junit:${versionCucumber}"

    compileOnly 'org.projectlombok:lombok:1.18.24'
    annotationProcessor 'org.projectlombok:lombok:1.18.24'

    testImplementation 'junit:junit:4.13.1'
    implementation 'org.testng:testng:6.14.3'
    implementation 'org.junit.jupiter:junit-jupiter:5.8.1'
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.2'

    implementation group: 'org.slf4j', name: 'slf4j-api', version: '2.0.0-alpha5'
    implementation group: 'org.slf4j', name: 'slf4j-simple', version: '2.0.0-alpha5'
    implementation group: 'org.apache.logging.log4j', name: 'log4j-core', version: '2.18.0'

    implementation 'io.github.bonigarcia:webdrivermanager:5.8.0'
    implementation 'com.github.javafaker:javafaker:1.0.2'



}
test {
    useJUnit {
        include "**/*";
        gradle.startParameter.continueOnFailure = true
        testLogging.showStandardStreams = true
        systemProperties System.getProperties()
        systemProperty "cucumber.filter.tags", System.getProperty("cucumber.filter.tags")
    }
}
```


## Execution

in order to execute the project and generates the Aggregate report provided by Serenity BDD, we open the `CMD` on the IDE and type the follow command.

```yml
    gradle clean test
```
these command executes all the declared scenarios on this project

```cmd
    3 actionable tasks: 3 executed
```

At the end we must go and open the file `index.html` that is located on on the following route

```yml
  <ProjectoName>\target\site\serenity\index.html
```

This Readme.md was made it by Michael