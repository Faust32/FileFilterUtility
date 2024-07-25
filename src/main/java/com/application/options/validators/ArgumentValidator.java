package com.application.options.validators;

public interface ArgumentValidator {
    boolean validate(String[] args) throws IllegalArgumentException;
}
