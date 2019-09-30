package de.cdiag.techday.dockercompose.producer;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerEndpoint {

	private final Logger logger = LogManager.getLogger(this.getClass());

	@GetMapping(path = "/produce", produces = MediaType.TEXT_PLAIN_VALUE)
	ResponseEntity produce() {
		logger.info("produce is called");
		return ResponseEntity.ok(String.valueOf(new Random().nextLong()));
	}
}
