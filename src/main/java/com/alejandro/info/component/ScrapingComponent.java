package com.alejandro.info.component;

import com.alejandro.info.util.DriverFactory;
import com.alejandro.info.util.NumberUtil;
import com.alejandro.info.util.WebConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ScrapingComponent {

    private final static Logger logger = LoggerFactory.getLogger(ScrapingComponent.class);
    private WebDriver driver;

    public ScrapingComponent(){
        this.driver = DriverFactory.getDriver();
        this.driver.get(WebConstants.BASE_URL);
    }

    public Integer getElementValueById(String id){
        try {
            return NumberUtil.toNumber(this.driver.findElement(By.cssSelector(id)).getText());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void clickIntoElement(String id){
        try {
            this.driver.findElement(By.cssSelector(id)).click();
        } catch (Exception e) {
            logger.warn("Cant click element: " + e.getMessage());
        }
    }

    public void closeDriver(){
        this.driver.close();
    }
}
