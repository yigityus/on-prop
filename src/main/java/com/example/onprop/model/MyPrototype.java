package com.example.onprop.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyPrototype {
    public MyPrototype(String name) {
        log.info("{} name is: {}", this.toString(), name);
    }
}
