package utilities;

import cucumber.api.java.es.Y;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdidasUI {
    public WebDriver driver;
    public AdidasUI(WebDriver driver) {
        this.driver = driver;
    }
    By listCategory =By.xpath("//div[contains(@class,'list-group')]/a[text()='Laptops']");
    public WebElement listCategory()
    {
        return driver.findElement(listCategory);
    }
    By sonyLaptop = By.xpath("//a[text()='Sony vaio i5']");
    public WebElement sonyLaptop()
    {
        return driver.findElement(sonyLaptop);
    }
    By addToCart= By.xpath("//a[text()='Add to cart']");
    public WebElement addToCart()
    {
        return driver.findElement(addToCart);
    }
    By listGroupCategory = By.xpath("//div[contains(@class,'list-group')]/a[text()='Laptops']");
    public WebElement listGroupCategory()
    {
        return driver.findElement(listGroupCategory);
    }
    By dellLaptop = By.xpath("//a[text()='Dell i7 8gb']");
    public WebElement dellLaptop()
    {
        return  driver.findElement(dellLaptop);
    }
    By cartbutton =By.xpath("//a[text()='Cart']");
    public WebElement cartButton()
    {
        return driver.findElement(cartbutton);
    }
    By deleteLaptop = By.xpath("//tr[@class='success'][2]/td[4]/a");
    public WebElement deleteLaptop()
    {
        return  driver.findElement(deleteLaptop);
    }
    By LaptopAmount = By.xpath("//tr[@class='success'][1]/td[3]");
    public  WebElement laptopAmount()
    {
        return  driver.findElement(LaptopAmount);
    }
    By PlaceOrder =By.xpath("//button[text()='Place Order']");
    public WebElement placeOder()
    {
        return driver.findElement(PlaceOrder);
    }
    By name = By.xpath("//input[@id='name']");
    public WebElement Name()
    {
        return  driver.findElement(name);
    }
    By country =By.xpath("//input[@id='country']");
    public WebElement Country()
    {
        return driver.findElement(country);
    }
    By City = By.xpath("//input[@id='city']");
    public WebElement City()
    {
        return driver.findElement(City);
    }
    By Card = By.xpath("//input[@id='card']");
    public WebElement Card()
    {
        return driver.findElement(Card);
    }
    By month =By.xpath("//input[@id='month']");
    public WebElement Month()
    {
        return  driver.findElement(month);
    }
    By Year =By.xpath("//input[@id='year']");
    public WebElement Year()
    {
        return driver.findElement(Year);
    }
    By purchaseButton =By.xpath("//button[text()='Purchase']");
    public WebElement Purchase()
    {
        return  driver.findElement(purchaseButton);
    }
    By captureIDandPurchaseAmount = By.xpath("//p[contains(@class,'lead text-muted')]");
    public WebElement captureIdandAmount()
    {
        return driver.findElement(captureIDandPurchaseAmount);
    }
    By Ok= By.xpath("//button[text()='OK']");
    public WebElement Ok()
    {
        return driver.findElement(Ok);
    }
}
