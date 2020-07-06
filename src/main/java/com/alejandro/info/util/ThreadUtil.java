package com.alejandro.info.util;

import com.alejandro.info.InfoApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ThreadUtil {

    private final static Logger logger = LoggerFactory.getLogger(Thread.class);

    public static void sleepLong() {
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            logger.error("Sleep thread fail");
        }
    }

    public static void sleepMedium() {
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            logger.error("Sleep thread fail");
        }
    }
}
