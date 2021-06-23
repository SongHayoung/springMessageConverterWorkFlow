package com.example.messageconverter.messageconverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.messageconverter")
public class MessageConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageConverterApplication.class, args);
	}

}
