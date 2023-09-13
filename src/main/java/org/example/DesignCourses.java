package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

public class DesignCourses extends Page {
    public static final String DESIGN_COURSE_PAGE = "https://ithillel.ua/courses/design";

    @Override
    public void goToPage() {
        Selenide.open(DESIGN_COURSE_PAGE);
    }

}
