package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

public class ProgrammingCourse extends Page implements HasAdditionalCourses {
    public static final String PROGRAMMING_COURSE_PAGE = "https://ithillel.ua/courses/programming";

    @Override
    public void goToPage() {
        Selenide.open(PROGRAMMING_COURSE_PAGE);
    }

    @Override
    public List<String> getCoursesTitles() {
        List<SelenideElement> courses = this.getCourses();
        return courses.stream()
                .map(c -> c.$x("descendant::p[contains(@class, 'profession-bar_title')]"))
                .map(SelenideElement::getOwnText)
                .toList();
    }

    @Override
    public List<SelenideElement> getAdditionalCourses() {
        List<SelenideElement> allAdditionalCourses = new ArrayList<>();

        List<SelenideElement> allProfessionBlocks = Selenide.$$(".block-profession");

        for (SelenideElement professionBlock : allProfessionBlocks) {

            List<SelenideElement> professionGroups = professionBlock.$$(".block-profession_group");
            if (professionGroups.size() == 2) {
                List<SelenideElement> additionalCourses = professionGroups.get(1).$$(".block-profession_item");
                allAdditionalCourses.addAll(additionalCourses);
            }
        }
        return allAdditionalCourses;
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
