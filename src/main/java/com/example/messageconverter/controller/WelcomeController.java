package com.example.messageconverter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.messageconverter.model.WelcomeRequest;
import com.example.messageconverter.model.WelcomeResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class WelcomeController {

	@PostMapping("welcome")
	public WelcomeResponse welcome(@RequestBody WelcomeRequest welcomeRequest) {
		log.info(String.format("welcome request [%s]", welcomeRequest.toString()));

		return WelcomeResponse.builder().welcomeMessage(welcomeRequest.getName()).build();
	}

	@GetMapping("welcome")
	public WelcomeResponse welcome(@RequestParam String name) {
		log.info(String.format("welcome request [%s]", name));

		return WelcomeResponse.builder().welcomeMessage(name).build();
	}
}
