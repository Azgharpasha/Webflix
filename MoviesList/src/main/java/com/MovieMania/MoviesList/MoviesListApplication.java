package com.MovieMania.MoviesList;

import com.MovieMania.MoviesList.filter.JWTFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class MoviesListApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesListApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public FilterRegistrationBean getBean(){
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new JWTFilter());
		bean.addUrlPatterns("/api/v3/*");
		return bean;
	}

}
