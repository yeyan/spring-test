package com.github.cm.web;

import com.github.cm.fibonacci.Fibonacci;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Ye Yan on 5/03/15.
 */

@Controller
@RequestMapping("/fib")
public class FibonacciController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected Fibonacci fibonacci;

    @RequestMapping(value = "/{value}", method = RequestMethod.GET)
    public String fibsequence(@PathVariable("value") long number, Model model) {

        model.addAttribute("seq", number);
        model.addAttribute("result", fibonacci.fibonacci(number));

        return "fib";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String fibsequence(Model model) {

        model.addAttribute("seq", 0);
        model.addAttribute("result", fibonacci.fibonacci(0));

        return "fib";
    }

}
