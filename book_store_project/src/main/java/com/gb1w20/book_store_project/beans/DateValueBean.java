package com.gb1w20.book_store_project.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bean to manage maximum and minimum possible dates that can be set by a DatePicker on our website
 * @author Giancarlo
 * @version April 4, 2020
 */
@Named("date")
@SessionScoped
public class DateValueBean implements Serializable {
    private final static Logger LOG = LoggerFactory.getLogger(DateValueBean.class);
    private Date minDate;
    private Date maxDate;
    
    /**
     * Sets the minimum and maximum dates that can be set
     * By: Giancarlo Biasiucci
     */
    @PostConstruct
    public void init() {
        LOG.error("hit");
        Calendar minDateCalendar = Calendar.getInstance();
        minDateCalendar.set(2020, 1, 1);
        minDate = minDateCalendar.getTime();
        LOG.debug("Start Date: " + minDateCalendar.getTime());
        
        Calendar maxDateCalendar = Calendar.getInstance();
        maxDateCalendar.set(2020, 12, 31);
        maxDate = maxDateCalendar.getTime();
        LOG.debug("End Date: " + maxDateCalendar.getTime());
    }

    public Date getMinDate()
    {
        return minDate;
    }
    
    public Date getMaxDate()
    {
        return maxDate;
    }
}
