package com.akatsukilab.xmpp;

import com.akatsukilab.xmpp.service.OpenFireRestClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan
public class XmppWrapperApplication implements CommandLineRunner {
	@Autowired
	OpenFireRestClient openFireRestClient;
	
	public static void main(String[] args) {
		SpringApplication.run(XmppWrapperApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// openFireRestClient.getUsers();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/users").allowedOrigins("http://localhost:3000");
			}
		};
	}

}
