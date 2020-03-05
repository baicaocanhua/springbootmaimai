package com.example.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
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


	public void aa(){
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<String> responseEntity=restTemplate.getForEntity(url+"?name={1}", String.class, "username");
//		String body = responseEntity.getBody();

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<TokenBeen> responseEntity =restTemplate.getForEntity(url+"?name={1}", TokenBeen.class, "username");
		if(responseEntity!=null){ TokenBeen body = responseEntity.getBody();5}
	}
}
