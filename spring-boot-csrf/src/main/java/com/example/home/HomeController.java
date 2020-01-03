package com.example.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jia.hch
 *
 */
@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	FilterRegistrationBean filterRegistrationBean;
	@RequestMapping("")
	public String index(HttpServletRequest request) {

		System.out.println(request.getAttribute(""));
		DefaultCsrfToken defaultCsrfToken=(DefaultCsrfToken)request.getAttribute("_csrf");

		System.out.println(defaultCsrfToken.getHeaderName()+"--"+defaultCsrfToken.getParameterName()+"--"+defaultCsrfToken.getToken());

		return "home";
	}

	@RequestMapping("update")
	public ModelAndView update(String name, String label) {

		ModelAndView mv = new ModelAndView("result");
		mv.addObject("name", name);
		mv.addObject("label", label);
		return mv;
	}
}
