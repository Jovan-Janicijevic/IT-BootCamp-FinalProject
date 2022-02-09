package webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Webtables {
    private WebDriver driver;
    private Actions actions;
    private Select select;


    public Webtables(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/*[1]")
    WebElement element;
    @FindBy(xpath = "//*[@id=\"item-3\"]")
    WebElement webTab;
    @FindBy(xpath = "//button[@id='addNewRecordButton']")
    WebElement add;
    @FindBy(xpath = "//div[@id='registration-form-modal']")
    WebElement regForm;
    @FindBy(xpath = "//input[@id='firstName']")
    WebElement firstName;
    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='userEmail']")
    WebElement userEmail;
    @FindBy(xpath = "//input[@id='age']")
    WebElement age;
    @FindBy(xpath = "//input[@id='salary']")
    WebElement salary;
    @FindBy(xpath = "//input[@id='department']")
    WebElement department;
    @FindBy(xpath = "//button[@id='submit']")
    WebElement submitButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]/div[4]/div/div[1]")
    WebElement newName;
    @FindBy(id = "delete-record-3")
    WebElement delete3;
    @FindBy(id = "delete-record-2")
    WebElement delete2;
    @FindBy(id = "delete-record-1")
    WebElement delete1;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[3]/div[3]")
    WebElement noRowsFind;



    public void webTables() throws InterruptedException {
        element.click();
        webTab.click();
        add.click();
        Thread.sleep(2000);

    }

    public String regform() {
        return regForm.getText();

    }

    public void fillForm(String name, String surname, String email, String yourAge, String yourSalary, String yourDepartment) {
        firstName.click();
        firstName.sendKeys(name);
        lastName.click();
        lastName.sendKeys(surname);
        userEmail.click();
        userEmail.sendKeys(email);
        age.click();
        age.sendKeys(yourAge);
        salary.click();
        salary.sendKeys(yourSalary);
        department.click();
        department.sendKeys(yourDepartment);
        submitButton.click();
    }

    public String newNameAdded() {
        return newName.getText();

    }

    public void webTab() throws InterruptedException {
        element.click();
        webTab.click();
    }

    public void deleteUser() {
        delete3.click();
        delete2.click();
        delete1.click();
    }
    public String emptyField(){
        return noRowsFind.getText();
    }

    }





