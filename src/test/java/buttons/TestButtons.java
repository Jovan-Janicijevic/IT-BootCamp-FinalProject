package buttons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TestButtons {
    private WebDriver driver;
    private Actions actions;
    private Select select;
    private Buttons buttons;

    @BeforeClass

    public void setupWebDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
    }

    @AfterTest
    public void close() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.close();
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
    }
    @Test
    public void doubleClickButton() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get("https://demoqa.com/buttons");
        Buttons buttons = new Buttons(driver);
        buttons.doubleClickButton_DoubleClick();
        String doubleClickMessageID = "You have done a double click";
        Assert.assertEquals(doubleClickMessageID, buttons.getexpectedResultdoubleClick());

    }
    @Test
    public void rightClickButton() {
        Actions actions = new Actions(driver);
        driver.get("https://demoqa.com/buttons");
        Buttons buttons = new Buttons(driver);
        buttons.rightClickButton_Rightclick();
        String rightClickMessageID = "You have done a right click";
        Assert.assertEquals(rightClickMessageID, buttons.getexpectedResultRightClick());
    }
    @Test
    public void DynamicClick() {
        Actions actions = new Actions(driver);
        driver.get("https://demoqa.com/buttons");
        Buttons buttons = new Buttons(driver);
        buttons.justClick();


    }
}
