package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        WebDriverManager web = WebDriverManager.chromedriver();
        web.setup();
        ChromeDriver dr = new ChromeDriver();
        dr.get("https://react-shopping-cart-67954.firebaseapp.com/");
//        dr.quit();
        WebElement star = dr.findElement(By.xpath("//a[text()='Star']"));
        System.out.println(star.getText());

        List<WebElement> elements = dr.findElements(By.xpath("//span[@class='checkmark']"));
        List<String> texts = new ArrayList<>();

        for (WebElement element : elements) {
            texts.add(element.getText());
        }

        for (String text : texts) {
            System.out.println(text);
        }

        WebElement box = dr.findElement(By.xpath("//div[@class='sc-1h98xa9-2 fGgnoG']/div[@title='Products in cart quantity']"));
        System.out.println(box.getText());

        WebElement text = dr.findElement(By.xpath("//main[@class='sc-ebmerl-4 iliWeY']/p"));
        System.out.println(text.getText());

        String[] xpaths = {
                "//p[@class='sc-124al1g-6 ljgnQL']/small",
                "//p[@class='sc-124al1g-6 ljgnQL']/b",
                "//p[@class='sc-124al1g-6 ljgnQL']/span",
                "//p[@class='sc-124al1g-4 eeXMBo']",
                "//p[@class='sc-124al1g-7 kIYxbn']/span",
                "//p[@class='sc-124al1g-7 kIYxbn']/b"
        };

        WebElement[] elementsArray = new WebElement[xpaths.length];
        String[] textsArray = new String[xpaths.length];

        for (int i = 0; i < xpaths.length; i++) {
            elementsArray[i] = dr.findElement(By.xpath(xpaths[i]));
            textsArray[i] = elementsArray[i].getText();
        }

        for (String text1 : textsArray) {
            System.out.println(text1);
        }

        WebElement imgElement = dr.findElement(By.xpath("//img[@alt='Jeremy Akeze - Doghouse IT Recruitment']"));
        String src = imgElement.getAttribute("src");
        System.out.println(src);

        WebElement add = dr.findElement(By.xpath("// button[@class='sc-124al1g-0 jCsgpZ']"));
        System.out.println(add.getText());
        WebElement img = dr.findElement(By.xpath("//div[@class='sc-joc36b-1 kCrsLA']/img"));
        System.out.println(img.getAttribute("src"));
        WebElement linkuser = dr.findElement(By.xpath("// div[@class='sc-joc36b-3 jCptDE']/p/a"));
        System.out.println(linkuser.getAttribute("href"));

        WebElement h4 = dr.findElement(By.xpath("//h4[text()='Work in the Netherlands']"));
        System.out.println(h4.getText());
        WebElement b = dr.findElement(By.xpath("//b[text()='follow me on Linkedin.']"));
        System.out.println(b.getText());
        WebElement tieude = dr.findElement(By.xpath("// div[@class='sc-joc36b-3 jCptDE']/p"));
        System.out.println(tieude.getText());
    }
}