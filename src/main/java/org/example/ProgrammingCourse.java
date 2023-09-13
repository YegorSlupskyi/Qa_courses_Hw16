package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;

import java.util.ArrayList;
import java.util.List;

public class ProgrammingCourse extends Page {
    public static final String PROGRAMMING_COURSE_PAGE = "https://ithillel.ua/courses/programming";

    @Override
    public void goToPage() {
        Selenide.open(PROGRAMMING_COURSE_PAGE);
    }

    @Override
    public List<SelenideElement> getCourses() throws InterruptedException {
        List<SelenideElement> allCourses = new ArrayList<>();
        List<SelenideElement> allProgrammingLanguagesTabs = getAllProgrammingLanguagesTabs();
        int index = 0;
        for (SelenideElement programmingLanguageTab : allProgrammingLanguagesTabs) {
            if (index != 0) {
                programmingLanguageTab.click();
            }
            List<SelenideElement> coursesForThisProgrammingLanguage = getCoursesForProgrammingLanguage();
            for (SelenideElement course : coursesForThisProgrammingLanguage) {
                allCourses.add(course);
            }
            index++;
        }
        return allCourses;
    }

    public static void printCourses(ProgrammingCourse programmingCourse) throws InterruptedException {
        List<SelenideElement> courses = programmingCourse.getCourses();
        for (SelenideElement course : courses) {
            SelenideElement courseTitle = course.$(".profession-bar_title");
            System.out.println(courseTitle.getText());
        }
    }




    @Override
    public void getOportunities() {

    }

    @Override
    public void goToCategory(String category) {

    }

    public List<SelenideElement> getAllProgrammingLanguagesTabs() {
        List<SelenideElement> programmingLanguagesTabs = Selenide.$$(".subcategories_item");
        return programmingLanguagesTabs;
    }

    public List<SelenideElement> getCoursesForProgrammingLanguage() {
        List<SelenideElement> CoursesForProgrammingLanguage = Selenide.$$(".block-profession_item");
        return CoursesForProgrammingLanguage;
    }
}
