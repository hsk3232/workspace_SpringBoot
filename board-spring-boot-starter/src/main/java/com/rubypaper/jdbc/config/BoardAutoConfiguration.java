package com.rubypaper.jdbc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rubypaper.jdbc.util.JDBCConnectionManager;

@Configuration
@EnableConfigurationProperties(JDBCConnectionManagerProperties.class)
public class BoardAutoConfiguration {
	@Autowired
	private JDBCConnectionManagerProperties properties;

	@Bean
	@ConditionalOnMissingBean
	JDBCConnectionManager getJDBCConnectionManager() {
		JDBCConnectionManager manager = new JDBCConnectionManager();
		manager.setDriverClass("com.mysql.cj.jdbc.Drvier");
		manager.setUrl("jdbc:mysql://localhost:3306/world");
		manager.setUsername("musthave");
		manager.setPassword("tiger");
		return manager;
	}
}
