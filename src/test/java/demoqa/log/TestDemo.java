package demoqa.log;

import emailgenerator.RandomEmail;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

import static org.testng.Assert.assertEquals;


public class TestDemo {
    private WebDriver driver;
    private Actions actions;
    private Select select;



    @BeforeClass

    public void setupWebDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

    }
    @BeforeMethod
    public void setUpBefore() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
    }

    @AfterTest
    public void close() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.close();
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
    }
    @Test
    public void testForms () throws IOException, InterruptedException{

        DemoQA demo = new DemoQA(driver);
        String randomEmail= RandomEmail.getRandomUserEmail();
        String putanja ="C:\\Users\\User\\Desktop\\QA.jpg";
        demo.fillTheForm("Petar", "Petrovic", randomEmail,
                "0624445777" , "May" , "1986", putanja , "Branislava Nusica 42", "Rajasthan");
        String submitingText = "Thanks for submitting the form";
        Assert.assertTrue(demo.getModal().contains(submitingText));
    }



}
