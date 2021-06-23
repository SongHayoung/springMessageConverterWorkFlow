package com.example.messageconverter.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AppInitEventListener {
	@Autowired
	private RequestMappingHandlerAdapter handlerAdapter;

	@EventListener
	public void handleContextRefresh(ApplicationStartedEvent event) {
		log.info("=====등록된 메세지 컨버터 목록====");
		handlerAdapter.getMessageConverters().forEach(converter -> log.info(converter.getClass().getName()));
	}
}
