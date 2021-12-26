package com.example.Taskin;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition( info = @Info(version = "1.0",
								 title = "Taskin Project",
								description = "Asking and Replying All Questions"))
public class TaskinApplication {
	public static void main(String[] args) {
		SpringApplication.run(TaskinApplication.class, args);
	}

}
