package textBox;

//import com.github.javafaker.Faker;
import emailgenerator.RandomEmail;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

public class TestTextBox {
    private WebDriver driver;

//    @DataProvider(name = "textBox")
//    public Object[][] textBox() {
//        faker = new Faker();
//
//        return new Object[][]{
//                {"1", faker.internet().emailAddress(), faker.address().fullAddress(), faker.address().fullAddress()},
//                {"2", faker.internet().emailAddress(), faker.address().fullAddress(), faker.address().fullAddress()},
//                {faker.name().fullName(), faker.internet().emailAddress(), faker.address().fullAddress(), faker.address().fullAddress()},
//                {faker.name().fullName(), faker.internet().emailAddress(), faker.address().fullAddress(), faker.address().fullAddress()}
//        };
//    }

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

    @Test
    public void testBox () throws IOException, InterruptedException {
        TextBox textBox = new TextBox(driver);
        String randomEmail = RandomEmail.getRandomUserEmail();
        String actualUrl = driver.getCurrentUrl();
        String expectedURL = "https://demoqa.com/";
        Assert.assertTrue(actualUrl.equals(expectedURL));


        textBox.TextBoxForm("Petar Popovic", randomEmail, "Partizanska 5", "Jug Bogdanova 6");
        String expectedName = "Petar Popovic";
        Assert.assertTrue(textBox.getDisplayedName().getText().contains(expectedName), "Tekst se ne poklapa");
        Assert.assertTrue(textBox.getNewBox().isDisplayed());
    }


    @AfterTest
    public void close() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.close();
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
    }
}

