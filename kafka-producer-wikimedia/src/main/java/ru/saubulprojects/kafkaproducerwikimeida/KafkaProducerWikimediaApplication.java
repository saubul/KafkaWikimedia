package ru.saubulprojects.kafkaproducerwikimeida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;
import ru.saubulprojects.kafkaproducerwikimeida.service.WikimediaChangesProducer;

@SpringBootApplication
@RequiredArgsConstructor
public class KafkaProducerWikimediaApplication implements CommandLineRunner{
	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerWikimediaApplication.class, args);
	}

	@Autowired
	private final WikimediaChangesProducer wikimediaChangesProducer;
	
	public void run(String... args) throws Exception {
		wikimediaChangesProducer.sendMessage();
	}

}
