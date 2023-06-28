package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class testClass {
    public WebDriver dr;
    public WebDriverWait ewait;

    @FindBy(how = How.XPATH, using = "//a[text()='Star']")
    public WebElement star;
    @FindBy(how = How.XPATH, using = "//main[@class='sc-ebmerl-4 iliWeY']/p")
    public WebElement textMain;
    @FindBy(how = How.XPATH, using = "//div[@class='sc-joc36b-1 kCrsLA']/img")
    public WebElement img;
    @FindBy(how = How.XPATH, using = "//div[@class='sc-joc36b-3 jCptDE']/p/a")
    public WebElement linkUser;
    @FindBy(how = How.XPATH, using = "//h4[text()='Work in the Netherlands']")
    public WebElement header;
    @FindBy(how = How.XPATH, using = "//b[text()='follow me on Linkedin.']")
    public WebElement follow;
    @FindBy(how = How.XPATH, using = "// div[@class='sc-joc36b-3 jCptDE']/p")
    public WebElement title;
    @FindBy(xpath = "//span[@class='checkmark']")
    public List<WebElement> elements;
    @FindBy(how = How.XPATH, using = "//button[@class='sc-124al1g-0 jCsgpZ']")
    public WebElement btnAddToCart;
    @FindBy(how = How.XPATH, using = "//button[text()='+']")
    public WebElement btnIncrease;
    @FindBy(how = How.XPATH, using = "//button[@class='sc-1h98xa9-0 gFkyvN']")
    public WebElement close;
    @FindBy(how = How.XPATH, using = "//div[@class='sc-124al1g-2 dwOYCh']")
    public WebElement product1;
    @FindBy(how = How.XPATH, using = "//div[@class='sc-124al1g-2 dwOYCh']/button")
    public WebElement addToCart;
    @FindBy(how = How.XPATH, using = "//div[@class='sc-124al1g-2 ekOVCH']/button")
    public WebElement addToCart2;
    @FindBy(how = How.XPATH, using = "//button[@class='sc-1h98xa9-11 gnXVNU']")
    public WebElement btnCheck;
    @FindBy(how = How.XPATH, using = "//button[@class='sc-11uohgb-5 gBQuHE']")
    public WebElement del;
    @FindBy(how = How.XPATH, using = "//button[@class='sc-1h98xa9-0 gFkyvN']")
    public WebElement closeMenu;

    public testClass() {
        dr = new ChromeDriver();
        PageFactory.initElements(dr, this);
        ewait = new WebDriverWait(dr, Duration.ofSeconds(5));
    }
    @Before
    public void setUp() {
        dr.get("https://react-shopping-cart-67954.firebaseapp.com/\"");
    }
    @Test
    public void test() throws Exception  {
        dr.manage().window().maximize();

        Thread.sleep(2000);

        System.out.println(star.getText());
        System.out.println(textMain.getText());
        System.out.println(img.getAttribute("src"));
        System.out.println(linkUser.getText());
        System.out.println(header.getText());
        System.out.println(follow.getText());
        System.out.println(title.getText());

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

        sizeXXL.click();

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

    public void waitUntil(WebElement element) {
        int tryTimes = 0;
        while (tryTimes < 2){
            try {
                ewait.until(ExpectedConditions.visibilityOf(element));
                break;
            }
            catch (StaleElementReferenceException se){
                tryTimes ++;
                if (tryTimes == 2)
                    throw se;
            }
        }
    }
    public void waitUntilPath(String path) throws Exception{
        int tryTimes = 0;
        while (tryTimes < 2){
            try {
                WebElement element = dr.findElement(By.xpath(path));
                ewait.until(ExpectedConditions.visibilityOf(element));
                break;
            }
            catch (StaleElementReferenceException se){
                tryTimes ++;
                if (tryTimes == 2)
                    throw se;
            }
        }
    }
}
