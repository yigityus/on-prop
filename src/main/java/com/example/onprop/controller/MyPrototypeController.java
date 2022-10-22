package com.example.onprop.controller;

import com.example.onprop.service.MyPrototypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class MyPrototypeController {

    private final MyPrototypeService myPrototypeService;

    @GetMapping
    public String name(@RequestParam String name) {
        myPrototypeService.usePrototype(name);
        return UUID.randomUUID().toString();
    }
}
