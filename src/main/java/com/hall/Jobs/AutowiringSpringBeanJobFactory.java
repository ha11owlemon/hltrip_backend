package com.hall.Jobs;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;

public class AutowiringSpringBeanJobFactory extends AdaptableJobFactory {
    @Autowired
    private AutowireCapableBeanFactory beanFactory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        // Call the super method to create the job instance
        Object jobInstance = super.createJobInstance(bundle);
        // Perform autowiring
        beanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
