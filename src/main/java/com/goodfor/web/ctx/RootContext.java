package com.goodfor.web.ctx;

import javax.sql.DataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableAspectJAutoProxy
//@EnableTransactionManagement
@Import({MyBatisContext.class, ServletContext.class})
@Configuration
@MapperScan(basePackages= {"com.goodfor.web"})
@ComponentScan(basePackages= {"com.goodfor.web"})
public class RootContext {
	
	@Bean
	public DataSource dataSource() {
		/**HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("org.mariadb.jdbc.Driver);
		hikariConfig.setJdbcUrl(""jdbc:mariadb://172.168.0.78/mysql");
		hikariConfig.setUsername("goodfor");
		hikariConfig.setPassword("goodfor");
		
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