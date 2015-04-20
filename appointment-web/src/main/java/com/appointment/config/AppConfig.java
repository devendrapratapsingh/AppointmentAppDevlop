package com.appointment.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mongodb.Mongo;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.appointment")
public class AppConfig {
	
}
