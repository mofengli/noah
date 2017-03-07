package com.noah.controllers;/**
 * Created by ljp on 2017/3/6.
 */

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ljp
 * @create 2017 03 06 17:24
 **/
@Controller
public class MainsiteErrorController implements ErrorController {
    private static final String ERROR_PATH = "/error";
    @RequestMapping(value=ERROR_PATH)
    public String handleError(){
        return "error/error";
    }
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
