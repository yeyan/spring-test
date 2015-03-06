package com.github.cm.web;

import com.github.cm.greetings.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ye Yan on 6/03/15.
 */
@Controller
public class GreetingsController {

    @Autowired
    private GreetingService greetingService;

    @RequestMapping(value ="/greetings/{username}", method = RequestMethod.GET)
    public String greetings(@PathVariable("username") String username, Model model) {
        model.addAttribute("message", greetingService.greetings(username));
        return "greetings";
    }

}
