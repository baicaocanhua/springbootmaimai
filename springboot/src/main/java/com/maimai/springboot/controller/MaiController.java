package com.maimai.springboot.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("maimaifile")
public class MaiController {

    @RequestMapping("pathmai")
    public String pp() throws IOException {
        String demoimg = "static/1.jpg";
        ClassPathResource tempResource = new ClassPathResource(demoimg);
        String path = tempResource.getURI().getPath();
        System.out.println(path);
        String parentpath = path.substring(0, path.lastIndexOf(demoimg));


        File file=new File(parentpath+"static/2.txt");

        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return parentpath;


    }

}
