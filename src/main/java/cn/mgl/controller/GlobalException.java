package cn.mgl.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author MongieLee
 * @version 1.0
 * @date 2022/10/28 13:29
 */
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(Exception.class)
    public Object exception(Exception e) {
        e.printStackTrace();
        return e.getMessage();
    }

    @ExceptionHandler(ArithmeticException.class)
    public Object arithmeticException() {
        return "ArithmeticException";
    }
}
