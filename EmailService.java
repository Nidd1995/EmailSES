package com.kuliza.lending.aramex.lmsportal.utils.services;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;
import com.kuliza.lending.aramex.lmsportal.domain.EmailConfig;
import com.kuliza.lending.aramex.lmsportal.utils.dto.EmailDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private EmailConfig emailConfig;

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    public void emailSend(EmailDTO emailDTO) {
        try {

            logger.info(emailConfig.getAccessKey() + " " + emailConfig.getSecretKey());
            AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(
                            emailConfig.getAccessKey(), emailConfig.getSecretKey())))
                    .withRegion(Regions.US_EAST_1).build();

            SendEmailRequest request = new SendEmailRequest()
                    .withDestination(
                            new Destination()
                                    .withToAddresses(emailDTO.getReceiver().getTo())
                                    .withCcAddresses(emailDTO.getReceiver().getCc())
                                    .withBccAddresses(emailDTO.getReceiver().getBcc()))
                    .withMessage(new Message()
                            .withBody(new Body()
                                    .withText(new Content()
                                            .withCharset("UTF-8").withData(emailDTO.getBody())))
                            .withSubject(new Content()
                                    .withCharset("UTF-8").withData(emailDTO.getSubject())))
                    .withSource(emailDTO.getSender());
            client.sendEmail(request);
            logger.info(client.sendEmail(request).toString());
            logger.info("Email sent!");


        } catch (Exception ex) {
            logger.info("The email was not sent. Error message: "
                    + ex.getMessage());
        }
    }

}
