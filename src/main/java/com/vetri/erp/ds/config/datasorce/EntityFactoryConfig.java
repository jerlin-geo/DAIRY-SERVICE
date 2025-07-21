package com.vetri.erp.ds.config.datasorce;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
public class EntityFactoryConfig {
	
	@Autowired
	Environment env;

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("routingDataSource") DataSource routingDataSource) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(routingDataSource);
        emf.setPackagesToScan("com.vetri.erp.ds.inventory.entity");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        
        Map<String, Object> jpaProperties = new HashMap<>();
        jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        jpaProperties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
        jpaProperties.put("hibernate.format_sql", env.getProperty("spring.jpa.properties.hibernate.format_sql"));
        emf.setJpaPropertyMap(jpaProperties);
        return emf;
    }

    @Bean
    PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
