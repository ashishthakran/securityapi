package com.ashish.security;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAsync
@EnableSwagger2
@ComponentScan({ "com.ashish.security" })
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.ashish.security.repository" })
@EntityScan(basePackages = {"com.ontrack.ashish.entity"})
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class SecurityApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SecurityApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SecurityApplication.class, args);
		System.out.println("Started...");
	}
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfigForPrimaryDatasource() {
		return new HikariConfig();
	}

	@Bean(name = "dataSource")
	@Primary
	public DataSource dataSource() {
		return new HikariDataSource(hikariConfigForPrimaryDatasource());
	}
	
	/**
	 * This method is used to configure swagger for Security API endpoints.
	 * 
	 * @return
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ashish.security.controllers")).paths(PathSelectors.any()).build()
				.apiInfo(apiInfo());
	}

	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("Security API Gateway", "Security API Gateway.", "1.0", "", "", "Apache 2.0",
				"http://www.apache.org/licenses/LICENSE-2.0");
		return apiInfo;
	}

}