package com.spring.statecity;

import java.util.HashMap;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/city")
public class CityController {
	@Autowired
	public CityService service; 
	@Autowired
	public StateService stservice;
	
	@RequestMapping(value="/addcity",method=RequestMethod.POST)
	public ModelAndView addcity(@ModelAttribute("city") citybn cbn) {
		HashMap<String, Object> model=new HashMap<String, Object>();
		model.put("cbn", new citybn());
		service.addCity(cbn);
		model.put("cities",service.getAll());
		model.put("states",stservice.getAll());
		return new ModelAndView("City",model);
	}
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public ModelAndView welcome(@ModelAttribute("city") citybn cbn) {
		HashMap<String, Object> model=new HashMap<String, Object>();
		model.put("cbn", new citybn());
		model.put("cities",service.getAll());
		model.put("states",stservice.getAll());
		return new ModelAndView("City",model);
	}
	@RequestMapping(value="/getall",method=RequestMethod.GET)
	public ModelAndView getall(@ModelAttribute("city") citybn cbn) {
		HashMap<String, Object> model=new HashMap<String, Object>();
		model.put("cbn", new citybn());
		model.put("cities",service.getAll());
		model.put("states",stservice.getAll());
		return new ModelAndView("City",model);
	}
	
}
