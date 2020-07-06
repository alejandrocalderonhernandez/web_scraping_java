package com.alejandro.info;

import com.alejandro.info.util.DriverFactory;
import com.alejandro.info.util.ThreadUtil;
import com.alejandro.info.util.WebConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InfoApplication implements CommandLineRunner {

	private final static Logger logger = LoggerFactory.getLogger(InfoApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(InfoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String accumulated = "";
		String active = "";
		logger.info("Start!");
		WebDriver driver = DriverFactory.getDriver();
		driver.get(WebConstants.BASE_URL);
		ThreadUtil.sleepLong();
		driver.findElement(By.cssSelector(WebConstants.CDMX)).click();
		ThreadUtil.sleepMedium();
		accumulated = driver.findElement(By.cssSelector(WebConstants.CONFIRMED_NUMBER)).getText();
		active = driver.findElement(By.cssSelector(WebConstants.ACTIVE_NUMBER)).getText();
		logger.info("Confirmed = " + accumulated);
		logger.info("Active = " + active);
		driver.close();
	}
}
