package buttons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class Buttons {
    private WebDriver driver;
    private Actions actions;
    Select select;
    private Buttons buttons;


    public Buttons(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickButton;
    @FindBy(id = "rightClickBtn")
    WebElement rightClickButton;
    @FindBy(xpath = "//*[@id=\"RAChC\"]")
    WebElement oneClick;
    @FindBy (xpath = "//*[@id=\"doubleClickMessage\"]")
    WebElement expectedResultdoubleClick;
    @FindBy (xpath = "//*[@id=\"rightClickMessage\"]")
    WebElement expectedResultRightClick;



    

    public void doubleClickButton_DoubleClick() {
        Actions actions = new Actions(driver);
        actions.moveToElement(doubleClickButton).perform();
        actions.doubleClick().perform();
    }

    public String getexpectedResultdoubleClick (){
        return expectedResultdoubleClick.getText();
    }

    public void rightClickButton_Rightclick (){
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickButton).build().perform();
    }
    public String getexpectedResultRightClick (){
        return expectedResultRightClick.getText();
    }
    public void justClick(){
        Actions actions = new Actions(driver);
        actions.moveToElement(oneClick).click();

    }
}
