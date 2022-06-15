package ru.saubulprojects.kafkaproducerwikimeida.service;

import java.net.URI;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

import lombok.RequiredArgsConstructor;
import ru.saubulprojects.kafkaproducerwikimeida.handler.WikimediaChangesHandler;

@Service
@RequiredArgsConstructor
public class WikimediaChangesProducer {
	
	//private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesProducer.class);
	
	private final KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage() throws InterruptedException {
		String topic = "wikimedia_topic";
		EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, topic);
		String url = "https://stream.wikimedia.org/v2/stream/recentchange";
		EventSource eventSource = new EventSource.Builder(eventHandler, URI.create(url)).build();
		eventSource.start();
	}
}
