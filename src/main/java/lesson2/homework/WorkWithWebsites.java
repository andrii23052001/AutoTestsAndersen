package lesson2.homework;

import org.openqa.selenium.*;
import WebDriverSetup.WebDriverSetup;

import java.util.Set;

//TASK2
/*2)Написать программу, которая будет открывать пять различных страниц в новых окнах:

        http://www.automationpractice.pl/index.php

        https://zoo.waw.pl/

        https://www.w3schools.com/

        https://www.clickspeedtester.com/click-counter/

        https://andersenlab.com/

        Прописать цикл, который будет переключаться поочередно через все страницы,

        для каждой страницы выводить в консоль название и ссылку на эту страницу.

        И будет закрывать ту страницу в названии которой есть слово "Zoo".*/
public class WorkWithWebsites {

    static Set<String> windowHandles1;
    static Set<String> windowHandles2;
    static WebDriver driver = WebDriverSetup.setupDriver();

    public static void main(String[] args) {
        driver.get("http://www.automationpractice.pl/index.php");
        openNewTab("https://zoo.waw.pl/");
        openNewTab("https://www.w3schools.com/");
        openNewTab("https://www.clickspeedtester.com/click-counter/");
        openNewTab("https://andersenlab.com/");
        switchAllTabs();
        closeTab("Zoo");
        driver.quit();
    }

    private static void openNewTab(String url) {
        windowHandles1 = driver.getWindowHandles(); //получение всех открытых вкладок браузера
        ((JavascriptExecutor) driver).executeScript("window.open()");//открытых новой вкладки через джс
        windowHandles2 = driver.getWindowHandles();//получение уже старых вкладок + 1 новая открытая
        windowHandles2.removeAll(windowHandles1);//удаление старых вкладок
        driver.switchTo().window(windowHandles2.iterator().next());
        driver.get(url);
    }

    private static void switchAllTabs() {
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            driver.switchTo().window(tab);
            System.out.println("Текущая вкладка: " + driver.getCurrentUrl());
            System.out.println("Title: " + driver.getTitle());
        }
    }

    private static void closeTab(String subtitle) {
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            driver.switchTo().window(tab);
            String title = driver.getTitle();
            if (title.contains(subtitle)) {
                driver.close();
            }
        }
    }
}
