package mylab.notification.di.annot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mylab.notification.di.annot.EmailNotificationService;
import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.NotificationService;
import mylab.notification.di.annot.SmsNotificationService;

@Configuration
public class NotificationConfig {
	@Bean
	public NotificationService emailNotificationService() {
		return new EmailNotificationService("smtp.gmail.com", 587);
	}
	
	@Bean
	public NotificationService smsNotificationService() {
		return new SmsNotificationService("SKT");
	}
	
	@Bean
	public NotificationManager notificationManager() {
		return new NotificationManager(emailNotificationService(),	 smsNotificationService());
	}
}
