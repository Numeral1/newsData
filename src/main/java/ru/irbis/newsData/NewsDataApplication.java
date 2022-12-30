package ru.irbis.newsData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NewsDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsDataApplication.class, args);
	}

}
