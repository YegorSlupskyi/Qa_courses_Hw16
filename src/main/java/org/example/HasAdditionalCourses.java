package org.example;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

public interface HasAdditionalCourses {
    public List<SelenideElement> getAdditionalCourses();
    public List<String> getAdditionalCoursesTitles();
}
