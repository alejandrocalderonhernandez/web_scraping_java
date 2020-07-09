package com.alejandro.info.service;

import com.alejandro.info.InfoApplication;
import com.alejandro.info.util.DriverFactory;
import com.alejandro.info.util.MailUtil;
import com.alejandro.info.util.ThreadUtil;
import com.alejandro.info.util.WebConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashSet;
import java.util.Set;

public class SheduledJob {

    private final static Logger logger = LoggerFactory.getLogger(SheduledJob.class);

    @Scheduled(cron = "0 0 20 * * ?")
    public void getInfo(){
        Set<String> mails = new HashSet<>();
        mails.add("vanesadaymr@gmail.com");
        mails.add("alejandro950825@gmail.com");
        MailUtil m = new MailUtil();
        //m.sendMails(mails);
    }
}
