package com.example.mss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
public class KafkaStreamMssApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaStreamMssApplication.class, args);
	}

}
