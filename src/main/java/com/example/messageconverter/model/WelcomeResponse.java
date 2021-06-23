package com.example.messageconverter.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class WelcomeResponse {
	private String welcomeMessage;
}
