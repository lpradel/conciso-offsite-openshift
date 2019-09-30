package de.conciso.offsite.dockercompose.consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Consumer {

	private final Logger logger = LogManager.getLogger(this.getClass());

	private RestTemplate restTemplate = new RestTemplate();

	@Value("${host:localhost}")
	private String host;

	@Value("${port:8282}")
	private String port;

	@Scheduled(fixedRate = 2500L)
	public void call() {
		ResponseEntity<String> response = restTemplate.getForEntity("http://" + host + ":" + port + "/produce", String.class);
		log(response.getBody());
	}

	private void log(String value) {
		logger.info("received data: " + value);
	}
}
