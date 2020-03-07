package org.egov.web.notification.mail.repository;

import org.egov.common.contract.request.RequestInfo;
import org.egov.web.notification.mail.config.ApplicationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRepository {

	private ServiceRequestRepository serviceRequestRepository;
	
	private ApplicationConfiguration config;
	
	@Autowired
	public UserRepository(ServiceRequestRepository serviceRequestRepository, ApplicationConfiguration config) {
		this.serviceRequestRepository = serviceRequestRepository;
		this.config = config;
	}
	
	public String fetchUser(String tenantId, String mobileNo) {
		String url = config.getUserHost().concat(config.getUserContextPath()).concat(config.getUserSearchEndpoint());
		serviceRequestRepository.fetchResult(url, request);
		return null;
	}
	
}
