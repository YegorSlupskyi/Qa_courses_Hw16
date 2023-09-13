package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ProgrammingCourse programmingCourse = new ProgrammingCourse();
        programmingCourse.goToPage();

        ProgrammingCourse.printCourses(programmingCourse);

        Selenide.closeWebDriver();
    }
}