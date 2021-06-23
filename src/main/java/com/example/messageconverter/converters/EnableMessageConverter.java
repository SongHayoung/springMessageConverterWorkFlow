package com.example.messageconverter.converters;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

public class EnableMessageConverter extends AbstractHttpMessageConverter<Object> {

	public EnableMessageConverter() {
		super(StandardCharsets.UTF_8, new MediaType[]{MediaType.APPLICATION_JSON, new MediaType("application", "*+json")});
	}

	@Override
	protected boolean supports(Class<?> aClass) {
		return false;
	}

	@Override
	protected Object readInternal(Class<?> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
		return null;
	}

	@Override
	protected void writeInternal(Object o, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {

	}
}
