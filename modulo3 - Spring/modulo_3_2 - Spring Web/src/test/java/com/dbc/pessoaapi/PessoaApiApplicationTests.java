package com.dbc.pessoaapi;

import com.dbc.pessoaapi.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;

@SpringBootTest
class PessoaApiApplicationTests {

	@Autowired
	private EmailService emailService;

	@Test
	void contextLoads() throws MessagingException {
		emailService.sendWithAttachment();
	}

}
