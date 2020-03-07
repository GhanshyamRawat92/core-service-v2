package org.egov.web.notification.mail.consumer.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SMSRequest {
    private String mobileNumber;
    private String message;

    public Sms toDomain() {
        return new Sms(mobileNumber, message, Priority.HIGH);
    }
}
