package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ProgrammingCourse programmingCourse = new ProgrammingCourse();
        programmingCourse.goToPage();
        System.out.println();
        System.out.println("PROGRAMMING COURSES:");

        printStringList(programmingCourse.getCoursesTitles());
        printSelenideElements(programmingCourse.getOpportunities());

        System.out.println();
        System.out.println("ADDITIONAL COURSES:");
        printStringList(programmingCourse.getAdditionalCoursesTitles());
        Selenide.closeWebDriver();

    }
    public static void printStringList (List<String> list){
        for (String element : list){
            System.out.println(element);
        }
    }
    public static void printSelenideElements(List<SelenideElement> selenideElementList) {
        for (SelenideElement element : selenideElementList) {
            System.out.println(element.getText());
        }
    }
}