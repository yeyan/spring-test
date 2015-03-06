package com.github.cm.greetings;

import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Created by Ye Yan on 6/03/15.
 */
public interface GreetingService {

    @PreAuthorize("hasPermission(#username, 'isAdmin')")
    String greetings(String username);

}
