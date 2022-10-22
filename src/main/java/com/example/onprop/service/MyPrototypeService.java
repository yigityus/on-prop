package com.example.onprop.service;

import com.example.onprop.model.MyPrototype;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class MyPrototypeService {
    private final Function<String, MyPrototype> myPrototypeFactory;

    public void usePrototype(String name) {
        myPrototypeFactory.apply(name);
    }
}
