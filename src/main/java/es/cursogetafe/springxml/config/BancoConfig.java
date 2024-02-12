package es.cursogetafe.springxml.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:bbdd.properties")
@ComponentScan(basePackages = {
		"es.cursogetafe.banco.persistencia",
		"es.cursogetafe.banco.negocio",
		"es.cursogetafe.banco.presentacion"
		})
public class BancoConfig {

	@Autowired
	Environment prop;
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dbs = new BasicDataSource();
		dbs.setDriverClassName(prop.getProperty("bbdd.driver"));
		dbs.setUrl(prop.getProperty("bbdd.url"));
		dbs.setUsername(prop.getProperty("bbdd.user"));
		dbs.setPassword(prop.getProperty("bbdd.pass"));
		
		return dbs;
		
	}
	
	
}
