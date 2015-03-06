package com.github.cm.greetings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serializable;

/**
 * Created by Ye Yan on 6/03/15.
 */
public class GreetingsPermissionEvaluator implements PermissionEvaluator {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final GrantedAuthority ADMIN_AUTHORITY = new SimpleGrantedAuthority("ROLE_ADMIN");

    public GreetingsPermissionEvaluator() {
        logger.debug("permission evaluator created");
    }

    private boolean isAdmin(Authentication authentication) {
        return authentication.getAuthorities().contains(ADMIN_AUTHORITY);
    }

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        boolean result = false;

        logger.debug("target = {}, permission = {}", targetDomainObject, permission);

        if(isAdmin(authentication)) {
            result = true;
        }

        return result;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
