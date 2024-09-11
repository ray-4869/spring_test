package com.sbb.basic;

public class DataNotFoundException extends RuntimeException{
    private final static long serialVertionUID = 1L;
    public DataNotFoundException (String message) {
        super(message);
    }
}
