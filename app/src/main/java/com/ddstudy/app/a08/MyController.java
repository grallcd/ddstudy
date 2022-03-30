package com.ddstudy.app.a08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author grallcd
 * @since 2022/3/30
 */
@RestController
public class MyController {

    @Lazy
    @Autowired
    BeanForRequest beanForRequest;

    @Lazy
    @Autowired
    BeanForSession beanForSession;

    @Lazy
    @Autowired
    BeanForApplication beanForApplication;


    @GetMapping(value = "/test", produces = "text/html")
    public String beanScope(HttpServletRequest request) {
        return "<ul>" +
                "<li>" + "beanForRequest:" + beanForRequest + "</li>" +
                "<li>" + "beanForSession:" + beanForSession + "</li>" +
                "<li>" + "beanForApplication:" + beanForApplication + "</li>"
                + "</ul>";
    }
}
