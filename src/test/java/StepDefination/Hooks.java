package StepDefination;


import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import utilities.base;

import java.io.IOException;

public class Hooks extends base {

    public WebDriver driver;
    base baseobj= new base();

        @Before
        public void initilization()
        {
            driver=intiliazeDriver();
        }




    }






