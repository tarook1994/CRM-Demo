package com.example.CRMdemo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan("com.example.CRMdemo")
public class CrmDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmDemoApplication.class, args);

	}

	@Bean
	public SessionFactory sessionFactory(){
		SessionFactory sessionFactory = new Configuration().configure()
				.addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		return sessionFactory;
	}

}
