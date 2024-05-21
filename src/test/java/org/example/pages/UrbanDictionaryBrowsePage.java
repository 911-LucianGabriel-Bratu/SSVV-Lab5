package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("https://www.urbandictionary.com/")
public class UrbanDictionaryBrowsePage extends PageObject {

    @FindBy(xpath = "//*[@id=\"ud-root\"]/header/div[2]/div[1]/div/div/ul/li[1]/button")
    private WebElementFacade browseButton;

    @FindBy(xpath = "//*[@id=\"ud-root\"]/div/main/div/div[4]/section/div[2]/ul[2]/li[2]/a")
    private WebElementFacade lastButton;

    @FindBy(xpath = "//*[@id=\"ud-root\"]/div/main/div/div[4]/section/div[2]/ul[1]/li[1]/a")
    private WebElementFacade goBackFirstButton;

    public void startLetterSearch(char letter) {
        browseButton.click();
        WebElementFacade letterButton = findBy("//*[@id=\"ud-root\"]/header/div[2]/div[1]/div/div/ul/li[1]/div/div/ul/li[" + (letter - 'a' + 1) + "]/a");
        letterButton.click();
        WebElementFacade rejectAllButton = findBy("//*[@id=\"onetrust-reject-all-handler\"]");
        rejectAllButton.click();
        lastButton.click();
    }

    public void advance() {
        goBackFirstButton.click();
    }

    public boolean existsName(String name) {
        for (int index = 0; index < 50; index++) {
            try {
                WebElementFacade entry = findBy("//*[@id=\"ud-root\"]/div/main/div/div[4]/section/div[1]/ul/li["
                        + (index + 1) + "]/a");
                String text = entry.getText();
                if (text.contentEquals(name)) {
                    entry.click();
                    Thread.sleep(1000);
                    return true;
                }
            }
            catch (Exception e) {

            }
        }
        return false;
    }


}