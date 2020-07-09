package com.alejandro.info.service;

import com.alejandro.info.component.ScrapingComponent;
import com.alejandro.info.model.DataModel;
import com.alejandro.info.util.DriverFactory;
import com.alejandro.info.util.NumberUtil;
import com.alejandro.info.util.ThreadUtil;
import com.alejandro.info.util.WebConstants;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebScrapingServiceImpl implements IWebScraping{

    @Autowired
    private ScrapingComponent scraping;
    private Integer yesterdayActiveCasesMexico = 268008;
    private Integer yesterdayActiveCasesEdoMex = 39108;
    private Integer yesterdayActiveCasesCDMX = 53423;

    @Override
    public DataModel getData() {
        DataModel result = new DataModel();
        ThreadUtil.sleepLong();
        result.setTotalCasesMexico(scraping.getElementValueById(WebConstants.CONFIRMED_NUMBER));
        ThreadUtil.sleepSmall();
        result.setActiveCasesMexico(scraping.getElementValueById(WebConstants.ACTIVE_NUMBER));
        ThreadUtil.sleepSmall();
        result.setNewCasesPerDayMex(result.getTotalCasesMexico() - yesterdayActiveCasesMexico);
        ThreadUtil.sleepSmall();
        scraping.clickIntoElement(WebConstants.CDMX);
        ThreadUtil.sleepMedium();

        result.setTotalCasesCDMX(scraping.getElementValueById(WebConstants.CONFIRMED_NUMBER));
        ThreadUtil.sleepSmall();
        result.setActiveCasesCDMX(scraping.getElementValueById(WebConstants.ACTIVE_NUMBER));
        ThreadUtil.sleepSmall();
        result.setNewCasesPerDayCDMX(result.getTotalCasesCDMX() - yesterdayActiveCasesCDMX);
        ThreadUtil.sleepSmall();
        scraping.clickIntoElement(WebConstants.EDO_MEX);
        ThreadUtil.sleepMedium();

        result.setTotalCasesEdoMex(scraping.getElementValueById(WebConstants.CONFIRMED_NUMBER));
        ThreadUtil.sleepSmall();
        result.setActiveCasesEdoMex(scraping.getElementValueById(WebConstants.ACTIVE_NUMBER));
        ThreadUtil.sleepSmall();
        result.setNewCasesPerDayEdoMex(result.getTotalCasesEdoMex() - yesterdayActiveCasesEdoMex);
        ThreadUtil.sleepSmall();
        this.scraping.closeDriver();

        this.yesterdayActiveCasesMexico = result.getActiveCasesMexico();
        this.yesterdayActiveCasesCDMX = result.getActiveCasesCDMX();
        this.yesterdayActiveCasesEdoMex = result.getActiveCasesEdoMex();

        return result;
    }
}
