package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

public abstract class Page {
    public abstract void goToPage();
    public abstract List<SelenideElement> getCourses() throws InterruptedException;
    public abstract void getOportunities();
    public abstract void goToCategory(String category);
}
