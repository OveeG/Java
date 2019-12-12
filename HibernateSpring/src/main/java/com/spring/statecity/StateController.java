package com.spring.statecity;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.beans.Employee;

@Controller
@RequestMapping(value="/state")
public class StateController {
	
	@Autowired
	public StateService service;

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView addstate(@ModelAttribute("state") statebn stbn) {
		HashMap< String, Object> h=new HashMap<>();
		h.put("stbn",new statebn());
		
		service.addState(stbn);
		h.put("states",service.getAll());
		return new ModelAndView("State",h);
	}
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public ModelAndView home(@ModelAttribute("state") statebn stbn) {
		HashMap< String, Object> h=new HashMap<>();
		h.put("stbn",new statebn());
		h.put("states",service.getAll());
		return new ModelAndView("State",h);
	}
	@RequestMapping(value = "/get",method = RequestMethod.GET)
	public ModelAndView stateget() {
		HashMap< String, Object> h=new HashMap<>();
		h.put("stbn",new statebn());
		h.put("states",service.getAll());
		return new ModelAndView("State",h);
	}

}

