package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
public class DemoApplication {

	private final AtomicLong counter = new AtomicLong();

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(defaultValue = "World") String name) {

			return new Greeting(counter.incrementAndGet(), "Hello, " + name + "!");
}

	@GetMapping("/hello")
	public String hello() {
		return "Hello from my Spring Boot application!";
	}
	//@Bean
	//public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	//	return args -> {
	//		System.out.println("=== لیست Beanهای ارائه‌شده توسط Spring Boot ===");
	//		String[] beanNames = ctx.getBeanDefinitionNames();
	//		Arrays.sort(beanNames);
	//		for (String beanName : beanNames) {
	//			System.out.println(beanName);
	//		}
	//	};
	//}
}

