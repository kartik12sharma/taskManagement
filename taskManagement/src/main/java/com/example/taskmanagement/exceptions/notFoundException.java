package com.example.taskmanagement.exceptions;

public class notFoundException extends RuntimeException{
    public notFoundException(String ms){
        super(ms);
    }
}
