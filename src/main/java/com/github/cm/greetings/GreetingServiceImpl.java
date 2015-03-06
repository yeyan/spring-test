package com.github.cm.greetings;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Ye Yan on 6/03/15.
 */
@Component
public class GreetingServiceImpl implements GreetingService {

    protected List<String> templates = Arrays.asList(
            "Greetings %s.",
            "Hello %s.",
            "It is a pleasure to meet you, %s."
    );

    protected Random random = new Random();

    @Override
    public String greetings(String username) {
        return String.format(templates.get(random.nextInt(templates.size())), username);
    }
}
