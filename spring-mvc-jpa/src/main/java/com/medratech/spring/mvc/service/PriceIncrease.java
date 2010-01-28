package com.medratech.spring.mvc.service;

import org.apache.log4j.Logger;

public class PriceIncrease {
    private final Logger logger = Logger.getLogger(getClass());
    private int percentage;

    public void setPercentage(int i) {
        percentage = i;
        
        if (logger.isDebugEnabled()) {
            logger.info("Percentage set to " + i);
        }
    }

    public int getPercentage() {
        return percentage;
    }
}
