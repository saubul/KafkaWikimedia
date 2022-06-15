package ru.saubulprojects.kafkaconsumerdatabase.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
	
	@KafkaListener(topics = "wikimedia_topic", groupId = "myGroup")
	public void consumeMessage(String eventMessage) {
		LOGGER.info(String.format("Event message received: %s", eventMessage));
	}
}
