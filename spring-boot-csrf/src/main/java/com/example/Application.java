package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author jia.hch
 *
 */
@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {

	@Bean
	public FilterRegistrationBean csrfFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new CsrfFilter(new HttpSessionCsrfTokenRepository()));
		registration.addUrlPatterns("/*");
		return registration;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
