package demoqa.log;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class DemoQA {
    private WebDriver driver;
    private Actions actions;
    private Select select;



    public DemoQA(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/*[1]")
    WebElement forms;
    @FindBy(xpath = "//span[contains(text(),'Practice Form')]")
    WebElement practiceForm;
    @FindBy(xpath = "//input[@id='firstName']")
    WebElement inputFirstName;
    @FindBy(xpath = "//input[@id='lastName']")
     WebElement inputLastName;
    @FindBy(xpath = "//input[@id='userEmail']")
    WebElement inputEmail;
    @FindBy(xpath = "//label[contains(text(),'Male')]")
    WebElement gender;
    @FindBy(xpath = "//input[@id='userNumber']")
    WebElement mobileNumber;
    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    WebElement dateofBirth;
    @FindBy(xpath = "//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select")
    WebElement month;
    @FindBy(xpath = "//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select")
    WebElement year;
    @FindBy(xpath = "//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[1]")
    WebElement day;
    @FindBy(xpath = "//label[contains(text(),'Sports')]")
    WebElement hobbies;
    @FindBy(xpath = "//*[@id=\"uploadPicture\"]")
    WebElement inputPicture;
    @FindBy (xpath = "//textarea[@id='currentAddress']")
    WebElement currentAddress;
    @FindBy (xpath = "//*[@id=\"state\"]/div/div[1]/div[1]")
    WebElement selectState;
    @FindBy (xpath = "//div[contains(text(),'Rajasthan')]")
    WebElement rajahstan;
    @FindBy (xpath = "//div[contains(text(),'Select City')]")
    WebElement selectCity;
    @FindBy (xpath = "//div[contains(text(),'Jaipur')]")
    WebElement jaipur;
    @FindBy (xpath = "//button[@id='submit']")
    WebElement submit;
    @FindBy (xpath = "//*[@id=\"example-modal-sizes-title-lg\"]")
    WebElement modal;





    public void fillTheForm(String firstName, String lastName, String email, String phoneNumber, String mesec,
                            String godina, String pathtoFile, String address, String state) throws InterruptedException {

        forms.click();
        practiceForm.click();
        inputFirstName.click();
        inputFirstName.sendKeys(firstName);
        inputLastName.click();
        inputLastName.sendKeys(lastName);
        inputEmail.click();
        inputEmail.sendKeys(email);
        gender.click();
        mobileNumber.sendKeys(phoneNumber);
        dateofBirth.click();
        month.click();
        select = new Select(month);
//        select.selectByValue(mesec);
        select.selectByVisibleText(mesec);
        year.click();
        select=new Select(year);
        select.selectByValue(godina);
        day.click();

//        actions = new Actions(driver);
//        actions.moveToElement(day);
//        select = new Select(day);
//        select.selectByVisibleText(dan);

        Thread.sleep(1000);
        hobbies.click();

        Thread.sleep(2000);
        inputPicture.sendKeys(pathtoFile);
        currentAddress.click();
        currentAddress.sendKeys(address);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", selectState);
        selectState.click();

//        select = new Select(selectState);
//        select.selectByVisibleText(state);
        rajahstan.click();
        selectCity.click();
        jaipur.click();
        submit.click();


    }
public String getModal(){
        return modal.getText();
}
}

