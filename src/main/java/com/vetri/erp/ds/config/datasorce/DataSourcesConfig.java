package com.vetri.erp.ds.config.datasorce;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

@Configuration
public class DataSourcesConfig {


	@Autowired
	private Environment env;

	@Bean(name = "dataSource1")
	DataSource dataSource1() {
		return DataSourceBuilder.create().url(env.getProperty("app.datasource.url"))
				.username(env.getProperty("app.datasource.username"))
				.password(env.getProperty("app.datasource.password"))
				.driverClassName(env.getProperty("app.datasource.driver-class-name")).build();
	}


	@Primary
	@Bean(name = "routingDataSource")
	DataSource routingDataSource(@Qualifier("dataSource1") DataSource dataSource1) {
		DataSourceRouting routingDataSource = new DataSourceRouting();
		Map<Object, Object> dataSourceMap = new HashMap<>();
		dataSourceMap.put("dataSource1", dataSource1);
		routingDataSource.setTargetDataSources(dataSourceMap);
		routingDataSource.setDefaultTargetDataSource(dataSource1);
		return routingDataSource;
	}
}
