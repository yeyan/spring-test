package com.github.cm.fibonacci;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ye Yan on 5/03/15.
 */

@Component
public class Fibonacci {

    protected Map<Long, Long> cache = new HashMap<Long, Long>();

    @PostConstruct
    protected void init() {
        cache.put(0L, 1L);
        cache.put(1L, 1L);

        //cache the first 100 fibonacci sequence
        fibonacci(100);
    }

    public long fibonacci(long seq) {
        Long result = cache.get(seq);

        if(result == null) {
            result = fibonacci(seq - 1) + fibonacci(seq - 2);
            cache.put(seq, result);
        }

        return result;
    }

}
