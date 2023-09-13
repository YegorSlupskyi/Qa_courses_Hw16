package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

public class TestingCourse extends Page implements HasAdditionalCourses {
    public static final String TESTING_COURSE_PAGE = "https://ithillel.ua/courses/testing";


    @Override
    public void goToPage() {
        Selenide.open(TESTING_COURSE_PAGE);
    }

    @Override
    public List<String> getCoursesTitles() {
        return Selenide.$$(".profession-bar_title").stream()
                .map((SelenideElement courseTitle) -> courseTitle.getOwnText()).toList();
    }

    @Override
    public List<SelenideElement> getOpportunities() {
        List<SelenideElement> programmingCourseOpportunities = Selenide.$$(".opportunity-item_title.p-l");
        return programmingCourseOpportunities;
    }

    @Override
    public List<SelenideElement> getAdditionalCourses() {
        List<SelenideElement> coursesBlocks = Selenide.$$(".block-profession_group");
        SelenideElement lastBlock = coursesBlocks.get(coursesBlocks.size() - 1);
        List<SelenideElement> additionalCoursesList = Selenide.$$(".profession-bar_title");
        return additionalCoursesList;
    }

    @Override
    public List<String> getAdditionalCoursesTitles() {
        List<SelenideElement> allAdditionalCourses = getAdditionalCourses();
        return allAdditionalCourses.stream()
                .map((SelenideElement additionalCourse)
                        -> additionalCourse.$(".profession-bar_title").getOwnText())
                .toList();
    }
}
