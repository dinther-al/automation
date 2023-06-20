package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ChromeDriver dr = new ChromeDriver();
        dr.get("https://react-shopping-cart-67954.firebaseapp.com/");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement star = dr.findElement(By.xpath("//a[text()='Star']"));
        System.out.println(star.getText());

        WebElement text = dr.findElement(By.xpath("//main[@class='sc-ebmerl-4 iliWeY']/p"));
        System.out.println(text.getText());

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

        List<WebElement> elements = dr.findElements(By.xpath("//span[@class='checkmark']"));
        List<String> texts = new ArrayList<>();

        for (WebElement element : elements) {
            texts.add(element.getText());
        }

        WebElement sizeXS = null;
        for (WebElement element : elements) {
            if (element.getText().equals("XS")) {
                sizeXS = element;
                break;
            }
        }

        sizeXS.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement AddBtnCart = dr.findElement(By.xpath("//button[@class='sc-124al1g-0 jCsgpZ']"));
        AddBtnCart.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement increase = dr.findElement(By.xpath("//button[text()='+']"));
        increase.click();
        System.out.println(increase.getText());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//
        WebElement close = dr.findElement(By.xpath("//button[@class='sc-1h98xa9-0 gFkyvN']"));
        close.click();
        System.out.println(close.getText());
//
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sizeXS.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement sizeXXL = null;
        for (WebElement element : elements) {
            if (element.getText().equals("XXL")) {
                sizeXXL = element;
                break;
            }
        }

        sizeXXL.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement product1 = dr.findElement(By.xpath("//div[@class='sc-124al1g-2 dwOYCh']"));
        System.out.println(product1.getText());

        WebElement AddToCart1 = dr.findElement(By.xpath("//div[@class='sc-124al1g-2 dwOYCh']/button"));
        AddToCart1.click();

        WebElement AddToCart2 = dr.findElement(By.xpath("//div[@class='sc-124al1g-2 ekOVCH']/button"));
        AddToCart2.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement check = dr.findElement(By.xpath("//button[@class='sc-1h98xa9-11 gnXVNU']"));
        check.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Alert alert = dr.switchTo().alert();
        alert.accept();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement del = dr.findElement(By.xpath("//button[@class='sc-11uohgb-5 gBQuHE']"));
        del.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement del1 = dr.findElement(By.xpath("//button[@class='sc-11uohgb-5 gBQuHE']"));
        del1.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement del2 = dr.findElement(By.xpath("//button[@class='sc-11uohgb-5 gBQuHE']"));
        del2.click();

        dr.quit();
    }
}