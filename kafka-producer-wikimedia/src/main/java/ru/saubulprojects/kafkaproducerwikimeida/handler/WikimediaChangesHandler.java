package ru.saubulprojects.kafkaproducerwikimeida.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;


public class WikimediaChangesHandler implements EventHandler{

	private final KafkaTemplate<String, String> kafkaTemplate;
	private final static Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesHandler.class);
	private String topic;
	
	public WikimediaChangesHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
		this.kafkaTemplate = kafkaTemplate;
		this.topic = topic;
	}
	
	public void onOpen() throws Exception {
		
	}

	public void onClosed() throws Exception {
		
	}

	public void onMessage(String event, MessageEvent messageEvent) throws Exception {
		LOGGER.info(String.format("Event data: %s", messageEvent.getData()));
		kafkaTemplate.send(topic, messageEvent.getData());
	}

	public void onComment(String comment) throws Exception {
		
	}

	public void onError(Throwable t) {
		
	}

}
