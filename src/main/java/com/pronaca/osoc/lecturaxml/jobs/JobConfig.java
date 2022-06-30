package com.pronaca.osoc.lecturaxml.jobs;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import com.pronaca.osoc.lecturaxml.loaderxml.FactoryLoaderXml;

@Configuration
@EnableScheduling
public class JobConfig implements SchedulingConfigurer {

	private Logger log = LoggerFactory.getLogger(JobConfig.class);
	@Autowired
	Environment env;

	@Autowired
	private FactoryLoaderXml factoryLoaderXml;

	@Bean(destroyMethod = "shutdown")
	public Executor taskExecutor() {
		return Executors.newScheduledThreadPool(100);
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(taskExecutor());
		taskRegistrar.addTriggerTask(new Runnable() {
			@Override
			public void run() {
				log.info("Ejecuta Cron...");
				try {
					factoryLoaderXml.getIAplicaPromocionLoaderView().loadJob();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, new Trigger() {
			@Override
			public Date nextExecutionTime(TriggerContext triggerContext) {
				Calendar nextExecutionTime = new GregorianCalendar();
				Date lastActualExecutionTime = triggerContext.lastActualExecutionTime();
				Calendar fechaInicio = GregorianCalendar.getInstance();
				fechaInicio.set(fechaInicio.get(Calendar.YEAR), fechaInicio.get(Calendar.MONTH),
						fechaInicio.get(Calendar.DAY_OF_MONTH), 0, 2);
				fechaInicio.add(Calendar.MINUTE, 30);
				nextExecutionTime
						.setTime(lastActualExecutionTime != null ? lastActualExecutionTime : fechaInicio.getTime());
				nextExecutionTime.add(Calendar.HOUR_OF_DAY, env.getProperty("job.frecuently", Integer.class)); 
				return nextExecutionTime.getTime();
			}
		});

	}
}