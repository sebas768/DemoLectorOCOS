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

import com.pronaca.osoc.lecturaxml.loaderxml.ILoaderXml;

@Configuration
@EnableScheduling
public class JobConfig implements SchedulingConfigurer {

	private Logger log = LoggerFactory.getLogger(JobConfig.class);
	
	@Autowired
	Environment env;

	@Autowired
	private ILoaderXml iLoaderxML;

	@Bean(destroyMethod = "shutdown")
	Executor taskExecutor() {
		return Executors.newScheduledThreadPool(100);
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskLecturaXml) {
		taskLecturaXml.setScheduler(taskExecutor());
		taskLecturaXml.addTriggerTask(new Runnable() {
			@Override
			public void run() {
				log.info("Ejecuta Cron - Lectura XML SFTP...");
				try {
					iLoaderxML.loadXml();
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
				fechaInicio.set(fechaInicio.get(Calendar.YEAR), fechaInicio.get(Calendar.MONTH), fechaInicio.get(Calendar.DAY_OF_MONTH), 2, 0, 0);
					
					System.out.println("Inicia lectura");
					System.out.println(fechaInicio.getTime().toString());
					System.out.println("Inicia anterior lectura");
					System.out.println(lastActualExecutionTime != null ? lastActualExecutionTime : fechaInicio.getTime());

				nextExecutionTime.setTime(lastActualExecutionTime != null ? lastActualExecutionTime : fechaInicio.getTime());
				nextExecutionTime.add(Calendar.MINUTE, env.getProperty("job.frecuently.lectura", Integer.class));
				if (nextExecutionTime.get(Calendar.HOUR_OF_DAY) == 1) {
					nextExecutionTime.add(Calendar.HOUR_OF_DAY, env.getProperty("job.frecuently.add", Integer.class));
				}

					System.out.println("Inicia nueva lectura");
					System.out.println(nextExecutionTime.getTime());

				return nextExecutionTime.getTime();
			}
		});
		taskLecturaXml.addTriggerTask(new Runnable() {
			@Override
			public void run() {
				log.info("Ejecuta Cron - Delete files SFTP...");
				try {
					iLoaderxML.deleteXml(); 
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
				fechaInicio.set(fechaInicio.get(Calendar.YEAR), fechaInicio.get(Calendar.MONTH), fechaInicio.get(Calendar.DAY_OF_MONTH), 11, 0, 0);
					
					System.out.println("Inicia delete");
					System.out.println(fechaInicio.getTime().toString());
					System.out.println("Inicia anterior delete");
					System.out.println(lastActualExecutionTime != null ? lastActualExecutionTime : fechaInicio.getTime());

				nextExecutionTime.setTime(lastActualExecutionTime != null ? lastActualExecutionTime : fechaInicio.getTime());
				nextExecutionTime.add(Calendar.MINUTE, env.getProperty("job.frecuently.delete", Integer.class));
					
					System.out.println("Inicia nueva delete");
					System.out.println((nextExecutionTime.getTime()));

				return nextExecutionTime.getTime();
			}
		});

	}
}