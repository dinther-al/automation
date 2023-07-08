package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CommonPageObject {
    public static WebDriver edriver;
    public static WebDriverWait ewait;
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

    public CommonPageObject(WebDriver driver) throws Exception {
        edriver = new ChromeDriver();
        PageFactory.initElements(edriver, this);
        ewait = new WebDriverWait(edriver, Duration.ofSeconds(5));
        edriver.get("https://react-shopping-cart-67954.firebaseapp.com/");
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
                WebElement element = edriver.findElement(By.xpath(path));
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
