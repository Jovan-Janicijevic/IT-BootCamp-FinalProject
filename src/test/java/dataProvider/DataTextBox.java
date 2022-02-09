package dataProvider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataTextBox {
    private WebDriver driver;

    public DataTextBox(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]")
    WebElement element;
    @FindBy (xpath = "//*[@id=\"item-0\"]/span")
    WebElement textBox;
    @FindBy (xpath = "//*[@id=\"userName\"]")
    WebElement fullName;
    @FindBy (xpath = "//*[@id=\"userEmail\"]")
    WebElement emailAdress;
    @FindBy (xpath = "//*[@id=\"currentAddress\"]")
    WebElement currentAdress;
    @FindBy (xpath = "//*[@id=\"permanentAddress\"]")
    WebElement permanentAdress;
    @FindBy (xpath = "//*[@id=\"submit\"]")
    WebElement submit;
    @FindBy (xpath = "//*[@id=\"name\"]")
    WebElement displayedName;
    @FindBy(xpath = "//*[@id=\"output\"]/div")
    WebElement newBox;



    public void TextBoxForm(String firstNameLastName, String email, String trenutnaAdresa, String stalnaAdresa){
        element.click();
        textBox.click();
        fullName.click();
        fullName.sendKeys(firstNameLastName);
        emailAdress.click();
        emailAdress.sendKeys(email);
        currentAdress.click();
        currentAdress.sendKeys(trenutnaAdresa);
        permanentAdress.click();
        permanentAdress.sendKeys(stalnaAdresa);
        submit.click();


    }
    public WebElement getDisplayedName (){
        return displayedName;
    }
    public WebElement getNewBox () {
        return newBox;
    }


}
