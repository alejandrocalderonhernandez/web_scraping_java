package com.alejandro.info.util;

import com.alejandro.info.component.ScrapingComponent;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;

public class NumberUtil {

    private final static Logger logger = LoggerFactory.getLogger(ScrapingComponent.class);

    public static Integer toNumber(String arg){
        String number = normalize(arg);
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            logger.error("Error to parse String", e);
            throw new IllegalArgumentException();
        }
    }
    private static String normalize(String arg) {
        return (arg.contains(",")) ? arg.replace(",", "") : arg;
    }


}
