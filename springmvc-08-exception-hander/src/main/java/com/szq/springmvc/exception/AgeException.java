package com.szq.springmvc.exception;

//根据年龄抛出异常
public class AgeException extends MyUserException{
    public AgeException() {
        super();
    }

    public AgeException(String message) {
        super(message);
    }
}
