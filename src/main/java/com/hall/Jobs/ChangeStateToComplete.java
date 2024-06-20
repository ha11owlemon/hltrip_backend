package com.hall.Jobs;

import com.hall.Bean.Orders;
import com.hall.Service.orderService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class ChangeStateToComplete extends QuartzJobBean {

    @Autowired
    orderService orderService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("fdfdfdfdfdfdfd");
        orderService.ChangeStateToComplete();
    }
}


