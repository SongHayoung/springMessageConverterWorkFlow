package com.example.messageconverter.converters;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.util.StreamUtils;

import com.example.messageconverter.model.WelcomeResponse;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.ser.FilterProvider;

public class WelcomeResponseMessageConverter extends AbstractHttpMessageConverter<WelcomeResponse> {
	private static final MediaType WELCOME_RESPONSE = new MediaType("welcome", "response");
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

	public WelcomeResponseMessageConverter() {
		super(DEFAULT_CHARSET, WELCOME_RESPONSE);
	}

	@Override
	protected boolean supports(Class<?> clazz) {
		return clazz == WelcomeResponse.class;
	}

	@Override
	protected WelcomeResponse readInternal(Class<? extends WelcomeResponse> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
		return null;
	}

	@Override
	protected void writeInternal(WelcomeResponse welcomeResponse, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
		OutputStream outputStream = StreamUtils.nonClosing(httpOutputMessage.getBody());

		try {
			JsonGenerator generator = OBJECT_MAPPER.getFactory().createGenerator(outputStream, JsonEncoding.UTF8);
			Throwable var10 = null;

			try {
				WelcomeResponse value = WelcomeResponse.builder().welcomeMessage("Welcome " + welcomeResponse.getWelcomeMessage()).build();

				ObjectWriter objectWriter = OBJECT_MAPPER.writer();

				objectWriter.writeValue(generator, value);

				generator.flush();
			} catch (Throwable var26) {
				var10 = var26;
				throw var26;
			} finally {
				if (generator != null) {
					if (var10 != null) {
						try {
							generator.close();
						} catch (Throwable var25) {
							var10.addSuppressed(var25);
						}
					} else {
						generator.close();
					}
				}

			}
		} catch (InvalidDefinitionException var28) {
			throw new HttpMessageConversionException("Type definition error: " + var28.getType(), var28);
		} catch (JsonProcessingException var29) {
			throw new HttpMessageNotWritableException("Could not write JSON: " + var29.getOriginalMessage(), var29);
		}
	}
}
