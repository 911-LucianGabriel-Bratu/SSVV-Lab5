package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.UrbanDictionaryBrowsePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class EndUserUrbanDictionaryBrowse {

    UrbanDictionaryBrowsePage page;

    @Step
    public void start_initial_search(String character) {
        page.startLetterSearch(character.charAt(0));
    }

    public void advance() {
        page.advance();
    }

    @Step
    public boolean verify_existence(String name) {
        return page.existsName(name);
    }

    @Step
    public void is_the_home_page() {
        page.open();
    }

}
