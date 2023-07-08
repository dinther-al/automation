package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.CommonPageObject;
import pageObject.DataField;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class newClass extends CommonPageObject {
    public WebDriver dr;
    public WebDriverWait ewait;
    DataField dataField;

    public newClass() throws Exception {
        super(CommonPageObject.edriver);
        dr = CommonPageObject.edriver;
        ewait = CommonPageObject.ewait;
        dataField = new DataField("src/main/java/org/example/newClass.xlsx");
    }
    @Test
    public void test() throws Exception  {
        dr.manage().window().maximize();

        Thread.sleep(2000);

        System.out.println(star.getText());
        System.out.println(textMain.getText());

        try {
            Assert.assertEquals(dataField.getData(0,0),textMain.getText());
            System.out.println("match");
        } catch (Exception e) {
            System.out.println("not match");
        }

        System.out.println(img.getAttribute("src"));
        System.out.println(linkUser.getText());
        System.out.println(header.getText());
        System.out.println(follow.getText());
        System.out.println(title.getText());
//        System.out.println(dataField.getData(1,0));
        List<String> texts = new ArrayList<>();

        for (WebElement element : elements) {
            texts.add(element.getText());
        }

        WebElement sizeXS = null;
        for (WebElement element : elements) {
            System.out.println(texts);
            if (element.getText().equals("XS")) {
                sizeXS = element;
                break;
            }
        }

        waitUntil(sizeXS);

        try {
            Assert.assertEquals(dataField.getData(1,0), String.valueOf(texts.size()));
            System.out.println("match");
        } catch (Exception e) {
            System.out.println("not match");
        }

        Thread.sleep(2000);

        sizeXS.click();

        Thread.sleep(2000);

        btnAddToCart.click();

        waitUntil(btnIncrease);

        btnIncrease.click();

        Thread.sleep(2000);

        close.click();

        Thread.sleep(2000);

        sizeXS.click();

        WebElement sizeXXL = null;
        for (WebElement element : elements) {
            if (element.getText().equals("XXL")) {
                sizeXXL = element;
                break;
            }
        }

        Thread.sleep(2000);

        sizeXXL.click();

//        waitUntil(sizeXXL);
        Thread.sleep(2000);
        System.out.println(textMain.getText());

        try {
            Assert.assertEquals(dataField.getData(0,1), textMain.getText());
            System.out.println("match");
        } catch (Exception e) {
            System.out.println("not match");
        }

        Thread.sleep(2000);

        System.out.println(product1.getText());

        Thread.sleep(2000);

        addToCart.click();
        addToCart2.click();

        Thread.sleep(2000);

        btnCheck.click();

        Thread.sleep(2000);

        Alert alert = dr.switchTo().alert();
        alert.accept();

        Thread.sleep(2000);

        List<String> boxes = new ArrayList<>();

        for (WebElement cart : carts) {
            boxes.add(cart.getText());
        }

        try {
            Assert.assertEquals(dataField.getData(1,1), String.valueOf(boxes.size()));
            System.out.println("match");
        } catch (Exception e) {
            System.out.println("not match");
        }
        
        System.out.println(total.getText());

        try {
            Assert.assertEquals(dataField.getData(2,0), String.valueOf(total.getText()));
            System.out.println("match");
        } catch (Exception e) {
            System.out.println("not match");
        }
        del.click();

        Thread.sleep(2000);

        del.click();

        Thread.sleep(2000);

        del.click();

        Thread.sleep(2000);

        closeMenu.click();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        dr.quit();
    }
}
