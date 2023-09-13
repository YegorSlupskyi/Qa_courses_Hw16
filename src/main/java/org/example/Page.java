package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.Objects;

public abstract class Page {
    public abstract void goToPage();

    public List<SelenideElement> getCourses() {
        return Selenide.$$(".block-profession_item");
    }

    public List<String> getCoursesTitles() {
        return Selenide.$$(".profession-bar_title").stream()
                .map((SelenideElement courseTitle) -> courseTitle.getOwnText()).toList();
    }
    

    public List<SelenideElement> getOpportunities() {
        List<SelenideElement> courseOpportunities = Selenide.$$(".opportunity-item_title.p-l");
        return courseOpportunities;
    }

    public void goToCategory(String category) throws Exception {
        SelenideElement coursesDropdown = Selenide.$("button.site-nav-link[data-dropdown-trigger='coursesMenu']");
        coursesDropdown.click();
        List<SelenideElement> categorySelectorButtons = Selenide.$$(".cats-list_btn");
        for (SelenideElement button : categorySelectorButtons) {
            if (Objects.equals(button.getAttribute("data-category"), category)) {
                button.click();
                return;
            }
        }
        throw new Exception("There is no such button");
    }
}
