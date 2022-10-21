package com.example.onprop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class UsingMyPrototype {
    private final Function<String, MyPrototype> myPrototypeFactory;

    public void usePrototype(String name) {
        myPrototypeFactory.apply(name);
    }
}
