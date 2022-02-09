package webtables;

import emailgenerator.RandomEmail;
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

public class TestWebtables {

    private WebDriver driver;
    private Actions actions;
    Select select;
    private Webtables tables;
    @BeforeClass

    public void setupWebDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }
        @AfterTest
        public void close() throws IOException {
            WebDriver driver = new ChromeDriver();
            driver.close();
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        }

    @Test (priority = 0)
    public void tablesForm() throws InterruptedException {
        driver.get("https://demoqa.com/");
        Webtables tables = new Webtables(driver);
        tables.webTables();
        String registrationForm = "Registration Form";
        Assert.assertTrue(tables.regform().contains(registrationForm));
    }
    @Test(priority = 1)
    public void addNewUser() throws InterruptedException {
        driver.get("https://demoqa.com/");
        String randomEmail= RandomEmail.getRandomUserEmail();
        Webtables tables = new Webtables(driver);
        tables.webTables();
        String playerName = tables.firstName.getText();
        tables.fillForm("Lamina", "Diarra", randomEmail, "26", "1500", "FK Partizan");
        Assert.assertTrue(tables.newNameAdded().contains(playerName));


    }
    @Test (priority = 2)
    public void trashCan() throws InterruptedException {
        driver.get("https://demoqa.com/");
        Webtables tables = new Webtables(driver);
        tables.webTab();
        tables.deleteUser();
        String empty = "No rows found";
        Assert.assertEquals(tables.emptyField(), empty, "List is not empty");

    }



}
