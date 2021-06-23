package com.example.messageconverter.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.messageconverter.converters.DisableMessageConverter;
import com.example.messageconverter.converters.WelcomeRequestMessageConverter;
import com.example.messageconverter.converters.WelcomeResponseMessageConverter;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new WelcomeRequestMessageConverter());
		converters.add(new WelcomeResponseMessageConverter());
		converters.add(new DisableMessageConverter());
	}
}
