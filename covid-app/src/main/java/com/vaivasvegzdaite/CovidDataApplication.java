package com.vaivasvegzdaite;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaivasvegzdaite.model.WeeklyDataByCountry;
import com.vaivasvegzdaite.service.WeekleDataByCountryService;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class CovidDataApplication extends SpringBootServletInitializer {

	@Bean
	public Docket swaggerDocket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.vaivasvegzdaite")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Covid-19 WeeklyDataByCountry History App").version("0.0.1-SNAPSHOT").build();
	}

	public static void main(String[] args) {
		SpringApplication.run(CovidDataApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CovidDataApplication.class);
	}

	@Bean
	CommandLineRunner runner(WeekleDataByCountryService weekleDataByCountryService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<WeeklyDataByCountry>> typeReference = new TypeReference<List<WeeklyDataByCountry>>() {
			};

			InputStream inputStream = new URL("https://opendata.ecdc.europa.eu/covid19/nationalcasedeath/json/")
					.openStream();
			try {
				List<WeeklyDataByCountry> allData = mapper.readValue(inputStream, typeReference);
				weekleDataByCountryService.save(allData);
				System.out.println("Data saved succesfully!");
			} catch (IOException e) {
				System.out.println("Unable to save data: " + e.getMessage());
			}
		};
	}
}
