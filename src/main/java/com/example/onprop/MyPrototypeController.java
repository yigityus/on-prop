package com.example.onprop;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class MyPrototypeController {

    private final UsingMyPrototype usingMyPrototype;

    @GetMapping
    public String name(@RequestParam String name) {
        usingMyPrototype.usePrototype(name);
        return UUID.randomUUID().toString();
    }
}
