package com.example.messageconverter.converters;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import com.example.messageconverter.model.WelcomeRequest;

public class WelcomeRequestMessageConverter extends AbstractHttpMessageConverter<WelcomeRequest> {
	private static final MediaType WELCOME_REQUEST = new MediaType("welcome", "request");
	public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

	public WelcomeRequestMessageConverter() {
		super(DEFAULT_CHARSET, WELCOME_REQUEST);
	}

	@Override
	protected boolean supports(Class<?> clazz) {
		return clazz == WelcomeRequest.class;
	}

	@Override
	protected WelcomeRequest readInternal(Class<? extends WelcomeRequest> clazz, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
		String name = StreamUtils.copyToString(httpInputMessage.getBody(), DEFAULT_CHARSET);
		return WelcomeRequest.builder().name(name).requestDate(new Date()).build();
	}

	@Override
	protected void writeInternal(WelcomeRequest welcomeRequest, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
		return;
	}
}
