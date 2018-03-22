package com.rs.spbwebdemo;

import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@SpringBootApplication(exclude = JmxAutoConfiguration.class)
@PropertySource("classpath:application.properties")
public class App extends SpringBootServletInitializer {
	
	@Value("${entityManagerFactory.packagesToScan}")
	private String[] packagesToScan;
	@Value("${hibernate.dialect}")
	private String hibernateDialect;
	
    public static void main( String[] args )
    {
       SpringApplication.run(App.class, args);
    }    
    
    @Bean
    @ConfigurationProperties("spring.datasource")
	public DataSource jndiDataSource() throws IllegalArgumentException, NamingException {
		return DataSourceBuilder.create().build();
	}
    
    @Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) 
			throws IllegalArgumentException, NamingException{
		
		Map<String, String> properties = new HashMap<String, String>();
		properties.put("hibernate.dialect", hibernateDialect);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		return builder
			.dataSource(jndiDataSource())
			.packages(packagesToScan)
			.properties(properties)
			.build();
	}
}
