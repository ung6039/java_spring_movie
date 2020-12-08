package com.home.main.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.calendar.model.calendarDAO;
import com.home.calendar.model.calendarVO;
import com.home.calendar.model.monthVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private calendarDAO calendardao;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/main/",method=RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.info("WebStart! {} ",locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		System.out.println("main.do");
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("curmonth",calendardao.getCal().getCurmonth());
		model.addAttribute("months",calendardao.getCal().getMonths());
		
		return "WEB-INF/main/main";
	}
	
	@RequestMapping("main.do")
	public String main(){
		
		return "WEB-INF/main/home";
	}
}
