package com.alejandro.info.util;

import com.alejandro.info.model.DataModel;
import com.alejandro.info.service.IWebScraping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.stream.Stream;

@Component
public class HTMLBuilder {
    private final static Logger logger = LoggerFactory.getLogger(MailUtil.class);

    @Autowired
    private IWebScraping scraping;

    private static final String MEX_TOTAL = "--mextotal--";
    private static final String MEX_ACVTIVE = "--mexavtive--";
    private static final String MEX_NEW = "--mexnew--";
    private static final String CDMX_TOTAL = "--cdmxtotal--";
    private static final String CDMX_ACTIVE = "--cdmxavtive--";
    private static final String CDMX_NEW = "--cdmxnew--";
    private static final String EDO_TOTAL = "--edototal--";
    private static final String EDO_ACTIVE = "--edoavtive--";
    private static final String EDO_NEW = "--edonew--";
    private static final String DATE = "--date--";


    private static final String FILE_URI = "src/main/resources/template.html";

	public String buildHTML(){
	    StringBuilder sb = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(FILE_URI))) {
            stream.forEach(sb::append);
        } catch (IOException e) {
            logger.error("Error to read file", e);
        }
        return setDataIntoHTML(scraping.getData(), sb.toString());
    }

    private  String setDataIntoHTML(DataModel model, String html){
	    return html
                .replace(MEX_TOTAL, model.getTotalCasesMexico().toString())
                .replace(MEX_ACVTIVE, model.getActiveCasesMexico().toString())
                .replace(MEX_NEW, model.getNewCasesPerDayMex().toString())
                .replace(CDMX_TOTAL, model.getTotalCasesCDMX().toString())
                .replace(CDMX_ACTIVE, model.getActiveCasesCDMX().toString())
                .replace(CDMX_NEW, model.getNewCasesPerDayCDMX().toString())
                .replace(EDO_TOTAL, model.getTotalCasesEdoMex().toString())
                .replace(EDO_ACTIVE, model.getActiveCasesEdoMex().toString())
                .replace(EDO_NEW, model.getNewCasesPerDayEdoMex().toString())
                .replace(DATE, LocalDate.now().toString());
    }
}
