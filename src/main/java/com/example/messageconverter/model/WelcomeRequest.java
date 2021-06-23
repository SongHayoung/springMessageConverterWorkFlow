package com.example.messageconverter.model;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class WelcomeRequest {
	private String name;
	private Date requestDate;
}
