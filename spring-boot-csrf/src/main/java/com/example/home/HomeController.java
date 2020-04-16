package com.example.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jia.hch
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    FilterRegistrationBean filterRegistrationBean;

    @RequestMapping("")
    public String index(HttpServletRequest request) {

        System.out.println(request.getAttribute(""));
        DefaultCsrfToken defaultCsrfToken = (DefaultCsrfToken) request.getAttribute("_csrf");

        System.out.println(defaultCsrfToken.getHeaderName() + "--" + defaultCsrfToken.getParameterName() + "--" + defaultCsrfToken.getToken());

        return "home";
    }


    @RequestMapping("aa")
    @ResponseBody
    public String aa(HttpServletRequest request) {

        System.out.println(request.getAttribute(""));
        DefaultCsrfToken defaultCsrfToken = (DefaultCsrfToken) request.getAttribute("_csrf");

        System.out.println(defaultCsrfToken.getHeaderName() + "--" + defaultCsrfToken.getParameterName() + "--" + defaultCsrfToken.getToken());

        return "aa";
    }

    @RequestMapping("update")
    public ModelAndView update(String name, String label) {

        ModelAndView mv = new ModelAndView("result");
        mv.addObject("name", name);
        mv.addObject("label", label);
        return mv;
    }


//	public void aa(){
////		RestTemplate restTemplate = new RestTemplate();
////		ResponseEntity<String> responseEntity=restTemplate.getForEntity(url+"?name={1}", String.class, "username");
////		String body = responseEntity.getBody();
//
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<TokenBeen> responseEntity =restTemplate.getForEntity(url+"?name={1}", TokenBeen.class, "username");
//		if(responseEntity!=null){ TokenBeen body = responseEntity.getBody();5}
//	}

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(100);
        for (int i = 1; i <= 109; i++) {
            list.add(i);
        }
        Double d = list.size() / 10D;
        Double pageNumber = Math.ceil(d);
        int pageNumCount = pageNumber.intValue();
        List<Integer> pageList = null;
        int pageSize = 10;
        for (int pageNum = 1; pageNum <= pageNumCount; pageNum++) {
            pageList = list.stream().skip(pageSize * (pageNum-1)).limit(pageSize).collect(Collectors.toList());
            System.out.println(pageList);
        }


    }
}
