package shared;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import config.ConfigReader;
import config.WebDriverFactory;

public abstract class BaseTest {
    
    protected WebDriver driver;
 

    @BeforeEach
    public void setUp(){
        driver = WebDriverFactory.createDriver(ConfigReader.browser());
        driver.get(ConfigReader.baseUrl());

    }

    @AfterEach
    public void teardown(){
        if(driver != null){
            driver.quit();
        }
    }

}
