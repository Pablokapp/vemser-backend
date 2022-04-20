package br.com.dbc.vemser.pessoaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableFeignClients
@EnableScheduling
public class PessoaapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PessoaapiApplication.class, args);
	}

}
