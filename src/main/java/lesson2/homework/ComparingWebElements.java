package lesson2.homework;

import WebDriverSetup.WebDriverSetup;
import org.openqa.selenium.*;
//TASK3
/*3)Написать метод в параметры которого принимаются два ВебЭлемента.

        метод выводит в консоль информацию какой из двух элементов располагается  выше на странице,

        какой из элементов располагается левее на странице,

        а также какой из элементов занимает большую площадь.*/

public class ComparingWebElements {

    static WebDriver driver = WebDriverSetup.getInstance().setupDriver();

    public static void main(String[] args) {
        driver.get("https://andersenlab.com/");
        WebElement element1 = driver.findElement(By.xpath("//button[text()=\"Let’s discuss your project\"]"));
        WebElement element2 = driver.findElement(By.xpath("//a[@href='/pricing']"));
        compareWebElementsPositions(element1, element2);
        driver.quit();

    }

    public static void compareWebElementsPositions(WebElement element1, WebElement element2) {
        Point location1 = element1.getLocation();
        Point location2 = element2.getLocation();

        Dimension size1 = element1.getSize();
        Dimension size2 = element2.getSize();

/*        int width = element1.getSize().getWidth();
        int height = element1.getSize().getHeight();*/
        /*int area3 = width * height;*/

        int area1 = size1.getWidth() * size1.getHeight();
        int area2 = size2.getWidth() * size2.getHeight();

        if (location1.getY() > location2.getY()) {
            System.out.println("Element 2 is higher than Element 1");
        } else if (location2.getY() > location1.getY()) {
            System.out.println("Element 1 is higher than Element 2");
        } else {
            System.out.println("Both elements are at the same height");
        }

        if (location1.getX() > location2.getX()) {
            System.out.println("Element 2 is located to the left of Element 1");
        } else if (location2.getX() > location1.getX()) {
            System.out.println("Element 1 is located to the left of Element 2");
        } else {
            System.out.println("Both elements are at the same horizontal position");
        }

        if (area1 > area2) {
            System.out.println("Element 1 occupies a larger area than Element 2");
        } else if (area1 < area2) {
            System.out.println("Element 2 occupies a larger area than Element 1");
        } else {
            System.out.println("Both elements occupy the same area");
        }

        System.out.println("============================================================");
        System.out.println("Vertical position (Y) of element 1: " + location1.getY());
        System.out.println("Vertical position (Y) of element 2: " + location2.getY());
        System.out.println("Horizontal position (X) of element 1: " + location1.getX());
        System.out.println("Horizontal position (X) of element 2: " + location2.getX());
        System.out.println("Area of element 1: " + area1);
        System.out.println("Area of element 2: " + area2);
        /*  System.out.println(area3);*/
    }
}
  /*  В Java класс Dimension используется для представления размеров объекта в двумерном пространстве. Он часто используется в графических приложениях и веб-разработке для определения размеров различных элементов, таких как окна, изображения, компоненты интерфейса и другие.

        Класс Dimension обычно содержит два основных поля данных:

        width (ширина) - ширина объекта.
        height (высота) - высота объекта.
        Эти поля предоставляют информацию о размере объекта в соответствующих направлениях. Класс Dimension также предоставляет методы для доступа к этим полям и для выполнения операций, таких как сравнение размеров, вычисление площади и других.*/

/*  Point в Selenium WebDriver представляет собой точку на веб-странице, определяемую горизонтальной (X) и вертикальной (Y) координатами.
 *//*     Он используется для определения местоположения элементов на странице.*/