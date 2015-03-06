package com.github.cm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Ye Yan on 5/03/15.
 */
@ControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(AppException.class)
    public String handler() {
        return "error";
    }

}
