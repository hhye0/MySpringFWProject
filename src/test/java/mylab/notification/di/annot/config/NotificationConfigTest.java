package mylab.notification.di.annot.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import mylab.notification.di.annot.EmailNotificationService;
import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.NotificationService;
import mylab.notification.di.annot.SmsNotificationService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = NotificationConfig.class)
public class NotificationConfigTest {
	@Autowired
	private NotificationManager notificationManager;
	
	@Test
	public void testNotificationManager() {
		assertNotNull(notificationManager);
		
		NotificationService emailService = notificationManager.getEmailService();
		assertTrue(emailService instanceof EmailNotificationService);
		assertEquals("smtp.gmail.com", ((EmailNotificationService) emailService).getSmtpServer());
		assertEquals(587, ((EmailNotificationService) emailService).getPort());
		
		NotificationService smsService = notificationManager.getSmsService();
		assertTrue(smsService instanceof SmsNotificationService);
		assertEquals("SKT", ((SmsNotificationService) smsService).getProvider());
		
		notificationManager.sendNotificationByEmail("테스트 이메일");
		notificationManager.sendNotificationBySms("테스트 SMS");
	}

}
