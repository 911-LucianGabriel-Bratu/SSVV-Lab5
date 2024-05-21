package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.EndUserUrbanDictionary;
import org.example.steps.serenity.EndUserUrbanDictionaryBrowse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/UrbanDictionaryBrowseTestData.csv")
public class SearchByKeywordStoryBrowseDDT {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;


    @Steps
    public EndUserUrbanDictionaryBrowse endUser;

    public String letter;
    public String name;

    @Qualifier
    public String getQualifier() {
        return name;
    }


    @Issue("#WIKI-1")
    @Test
    public void browseWord() {
        endUser.is_the_home_page();
        endUser.start_initial_search(letter);
        int index = 0;
        for (; index < 10; index++) {
            if (endUser.verify_existence(name)) {
                break;
            }
            endUser.advance();
        }
        if (index == 10) {
            assertThat("Failure", false);
        }
    }

}
