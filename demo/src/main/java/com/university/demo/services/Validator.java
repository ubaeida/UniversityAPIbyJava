package com.university.demo.services;

public interface Validator<T> {
    void validate(T object);
}
