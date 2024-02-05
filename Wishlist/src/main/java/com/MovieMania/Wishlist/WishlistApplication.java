package com.MovieMania.Wishlist;

import com.MovieMania.Wishlist.filter.JWTFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@SpringBootApplication
@EnableDiscoveryClient
public class WishlistApplication {

	public static void main(String[] args) {
		SpringApplication.run(WishlistApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean getBean(){
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new JWTFilter());
		bean.addUrlPatterns("/api/v4/wishListService/*");
		return bean;
	}


}
