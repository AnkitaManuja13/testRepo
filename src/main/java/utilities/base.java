package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {

    public static WebDriver driver;
    public Properties prop;
    public  WebDriver intiliazeDriver() {
        try {


            prop = new Properties();
            FileInputStream fis = new FileInputStream("D:\\cctvautomation\\src\\main\\java\\data.properties");
            prop.load(fis);
            String browserName = prop.getProperty("browser");
            String url= prop.getProperty("url");

            if(browserName.equals("chrome"))
            {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Z00422NA\\Downloads\\chromedriver\\chromedriver.exe");
                driver = new ChromeDriver();
            }

        }
        catch (Exception ex)
        {

        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;

    }
}
