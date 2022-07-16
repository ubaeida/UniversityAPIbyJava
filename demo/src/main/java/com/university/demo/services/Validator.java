package com.university.demo.services;

import java.util.List;

public interface Validator<T> {
    void validate(T object);
}
