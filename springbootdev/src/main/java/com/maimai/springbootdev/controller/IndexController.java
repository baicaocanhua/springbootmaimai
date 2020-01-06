package com.maimai.springbootdev.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @RequestMapping("index")
    public String index() {
        return "index";
    }


    @RequestMapping("log")
    @ResponseBody
    public String log() {
        LOGGER.info("11111");
        LOGGER.debug("2222");
        LOGGER.error("222223333");
        return "11";
    }
}
