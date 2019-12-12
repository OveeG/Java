/*package com.spring.statecity;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;



@Configuration
@ComponentScan("com.spring.*")
public class ConfigurationAll implements WebApplicationInitializer {

	@Bean("ds")
	public BasicDataSource basicDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/jvdb");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		return ds;
	}
	
	@Bean("sf")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean ls = new LocalSessionFactoryBean();
		ls.setDataSource(basicDataSource());
		ls.setHibernateProperties(initializeHibernateProps());
		ls.setPackagesToScan("com.spring.*");
		return ls;
	}
	
	private Properties initializeHibernateProps() {
		Properties props =new Properties();
		props.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
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
	public void onStartup(ServletContext servletContext) throws ServletException {
	 	AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
        webCtx.register(ConfigurationAll.class);
        webCtx.setServletContext(servletContext);
        ServletRegistration.Dynamic servlet = 
        		servletContext.addServlet("dispatcher", new DispatcherServlet(webCtx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");		
}
	
}
*/