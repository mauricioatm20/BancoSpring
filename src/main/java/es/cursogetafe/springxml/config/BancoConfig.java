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
		"es.cursogetafe.banco.negocio"
		})
public class BancoConfig {

	@Autowired
	Environment prop;
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dbs = new BasicDataSource();
		dbs.setDriverClassName(prop.getProperty("bbd.driver"));
		dbs.setUrl(prop.getProperty("bbd.url"));
		dbs.setUsername(prop.getProperty("bbd.user"));
		dbs.setPassword(prop.getProperty("bbdd.pass"));
		
		return dbs;
		
	}
	
	
}
