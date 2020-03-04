package com.kuliza.lending.aramex.lmsportal.controller;

import com.kuliza.lending.aramex.lmsportal.utils.dto.EmailDTO;
import com.kuliza.lending.aramex.lmsportal.utils.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class EmailController {

    @Autowired
   private  EmailService mailSenderService;

    @RequestMapping(method = RequestMethod.POST, value = "/send-mail")
    public void sendMail(@RequestBody @Valid EmailDTO emailDTO){
        mailSenderService.emailSend(emailDTO);
    }

}
