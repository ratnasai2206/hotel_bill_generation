package com.hotelbillapplication.hotelbillapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title = "Hotel Bill Application OPEN-API",version = "1.0.0",description = "Hotel Bill Application API with Spring boot"),
servers = {
		@Server (url = "http://localhost:8080",description = " Development Hotel Bill Application OPEN API url"),
		@Server (url = "http://localhost:8081",description = "Testing Hotel Bill Application OPEN API url")
}
) 
public class HotelBillApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelBillApplication.class, args);
	}

}
