package dataProvider;

import com.github.javafaker.Faker;
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
    private Faker faker;

    @DataProvider(name = "textBox")
    public Object[][] textBox() {
        faker = new Faker();

        return new Object[][]{
                {faker.name().fullName(), faker.internet().emailAddress(), "Branka Bajica 9", faker.address().fullAddress()},
                {"2", faker.internet().emailAddress(), faker.address().fullAddress(), faker.address().fullAddress()},
                {faker.name().fullName(), "fakeemail@fake.com", faker.address().fullAddress(), faker.address().fullAddress()},
                {faker.name().fullName(), faker.internet().emailAddress(), faker.address().fullAddress(), faker.address().fullAddress()}
        };
    }

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



    @Test(dataProvider = "textBox")
    public void testTextBox(String firstNameLastName, String email, String trenutnaAdresa, String stalnaAdresa) {
        DataTextBox data = new DataTextBox(driver);
        data.TextBoxForm(firstNameLastName, email, trenutnaAdresa, stalnaAdresa);
        DataTextBox textBox = new DataTextBox(driver);
//        String expectedName = "1";
//        Assert.assertTrue(textBox.getDisplayedName().getText().contains(expectedName), "Tekst se ne poklapa");
        Assert.assertTrue(textBox.getNewBox().isDisplayed());
    }

    @AfterTest
    public void close() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.close();
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
    }
}