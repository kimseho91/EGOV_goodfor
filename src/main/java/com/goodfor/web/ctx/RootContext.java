package com.goodfor.web.ctx;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages= {"com.goodfor.web"})
@ComponentScan(basePackages= {"com.goodfor.web"})
public class RootContext {
	
	@Bean
	public DataSource dataSource() {
		/**HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
		hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/getmoney?serverTimezone=UTC");
		hikariConfig.setUsername("getmoney");
		hikariConfig.setPassword("getmoney");
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		*/
		  DriverManagerDataSource dataSource = new DriverManagerDataSource();
		    dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		    dataSource.setUrl("jdbc:mariadb://172.168.0.78/mysql");
		    dataSource.setUsername("goodfor");
		    dataSource.setPassword("goodfor");
		
		return dataSource;
	}	
	
}