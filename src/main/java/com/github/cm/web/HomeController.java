package com.github.cm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ye Yan on 5/03/15.
 */

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/test/error", method = RequestMethod.GET)
    public String testError() throws AppException {
        throw new AppException();
    }

}
