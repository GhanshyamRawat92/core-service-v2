package org.egov.web.notification.mail.consumer;

import org.egov.web.notification.mail.config.ApplicationConfiguration;
import org.egov.web.notification.mail.consumer.contract.SMSRequest;
import org.egov.web.notification.mail.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SmsNotificationListener {
	
	
	private UserRepository userRepository;
	
	private ApplicationConfiguration config;
	
	@Autowired
	public SmsNotificationListener(UserRepository userRepository) {
		this.userRepository = userRepository;
		this.config = config;
	}
	
	@KafkaListener(topics = "${kafka.topics.notification.sms.name}")
    public void process(SMSRequest request) {
		userRepository.fetchUser(config.getStateTenantId(), request.getMobileNumber());
    }
}
