package com.oneStopSolutions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"com.oneStopSolutions.admin", "com.oneStopSolutions.customer", "com.oneStopSolutions.operator"})
@EntityScan(basePackages = {"com.oneStopSolutions.admin", "com.oneStopSolutions.customer", "com.oneStopSolutions.operator"})
@EnableJpaRepositories(basePackages = {"com.oneStopSolutions.admin", "com.oneStopSolutions.customer", "com.oneStopSolutions.operator"})
public class OneStopSolutionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneStopSolutionsApplication.class, args);
	}

}
