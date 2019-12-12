package com.spring.config;

import java.util.List;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.fasterxml.jackson.databind.ObjectMapper;



@Configuration
@ComponentScan(basePackages = {"com.spring.*"})
public class SpringHibernateConfig extends WebMvcConfigurationSupport{

	  @Bean
	  public ObjectMapper getObjectMapper() {
	    return new ObjectMapper();
	  }

	  @Bean
	  public MappingJackson2HttpMessageConverter messageConverter() {
	    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	    converter.setObjectMapper(getObjectMapper());
	    return converter;
	  }

	  @Override
	  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	    converters.add(messageConverter());
	    addDefaultHttpMessageConverters(converters);
	  }

	
	@Bean("ds")
	public BasicDataSource basicDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/jvdb");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		return ds;
	}
	
	@Bean("sfactory")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean ls = new LocalSessionFactoryBean();
		ls.setDataSource(basicDataSource());
		ls.setHibernateProperties(initializeHibernateProps());
		ls.setPackagesToScan("com.spring.entities");
		return ls;
	}
	
	private Properties initializeHibernateProps() {
		Properties props =new Properties();
		props.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
		props.put(Environment.HBM2DDL_AUTO,"update");
		props.put(Environment.SHOW_SQL,"true");
		return props;
	}
	
	@Bean
	public InternalResourceViewResolver prepareViewResoulver() {
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setViewClass(JstlView.class);
		view.setPrefix("/WEB-INF/pages/");
		view.setSuffix(".jsp");
		return view;
	}
	
}
