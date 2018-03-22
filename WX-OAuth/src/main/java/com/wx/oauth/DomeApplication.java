package com.wx.oauth; /**
 * Choicesoft.com.cn Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cgm
 * @version $Id: SpringApplication.java, v 0.1 2018-03-22 19:34 cgm Exp $$
 */
@RestController
@EnableAutoConfiguration
@ComponentScan({"com.wx.oauth","com.wx.oauth.Servlet","com.wx.oauth.utils"})
public class DomeApplication {
    public static void main(String[] args) {
//        SpringApplication.run(DomeApplication.class,args);

        SpringApplication application = new SpringApplication(DomeApplication.class);
        ConfigurableApplicationContext context = application.run(args);
    }

    @RequestMapping("/in")
    String home() {
        return "Hello World!";
    }
}
