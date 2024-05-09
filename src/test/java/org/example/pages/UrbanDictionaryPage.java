package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("https://www.urbandictionary.com/")
public class UrbanDictionaryPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"ud-root\"]/header/div[2]/div[2]/form/div/input")
    private WebElementFacade searchTerms;

    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        searchTerms.sendKeys(Keys.ENTER);
    }

    public List<String> getDefinitions() {
        List<WebElementFacade> definitions = findAll(By.cssSelector(".definition.bg-white.mb-4.shadow-light.dark\\:bg-yankees.dark\\:text-white.rounded-md.overflow-hidden"));

        List<String> filteredDefinitions = definitions.stream()
                .filter(element -> element.findElements(By.className("break-words")).size() > 0)
                .map(element -> element.getText())
                .collect(Collectors.toList());

        return filteredDefinitions;
    }
}