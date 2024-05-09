package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.UrbanDictionaryPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserUrbanDictionary {

    UrbanDictionaryPage urbanDictionaryPage;

    @Step
    public void enters(String keyword) {
        urbanDictionaryPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        urbanDictionaryPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(urbanDictionaryPage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void is_the_home_page() {
        urbanDictionaryPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
}