package com.sysco.ordermanager.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by vibodhab on 2/8/18.
 */
@RestController
public class SwaggerController {

    @GetMapping("/")
    public ModelAndView method() {
        return new ModelAndView("redirect:" + "http://localhost:8080/swagger-ui.html");

    }
}
