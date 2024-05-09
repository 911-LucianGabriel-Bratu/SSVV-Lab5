package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import org.example.steps.serenity.EndUserSteps;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps anna;

    @Issue("#WIKI-1")
    @Test
    public void searching_by_keyword_apple_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("apple");
        anna.should_see_definition("A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates.");

    }

    @Test
    public void searching_by_keyword_banana_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("pear");
        anna.should_see_definition("An edible fruit produced by the pear tree, similar to an apple but typically elongated towards the stem.");
                                   // An edible fruit produced by the pear tree, similar to an apple but typically elongated towards the stem.
    }

    @Test
    public void searching_by_keyword_bmw_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("BMW");
        anna.should_see_definition("a manufacturer of motor vehicles (Bayerische Motoren-Werke (Bavarian Motor Works)).");
    }

    @Test
    public void searching_by_keyword_hyundai_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("Hyundai");
        anna.should_see_definition("A car manufactured by the Hyundai Motor Group.");
    }

    @Pending @Test
    public void searching_by_ambiguious_keyword_should_display_the_disambiguation_page() {
    }
} 