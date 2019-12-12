/*package com.spring.statecity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StateCityMain {
	public static void main(String[] args) {
		//ApplicationContext context=new AnnotationConfigApplicationContext(ConfigurationAll.class);
		StateServiceImpl st=(StateServiceImpl) context.getBean("stservice");
		statebn stbn1=new statebn(3, "MadhyaPradesh", "MP");
		
		 
		//CityServiceImpl c=(CityServiceImpl) context.getBean("cityservice");
		citybn cbn=new citybn(2, "Kolhapur", 415234);
		//c.addCity(cbn);
		//System.out.println(st.getAll());
		
	}

}
*/