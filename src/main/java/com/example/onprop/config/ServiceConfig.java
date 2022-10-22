package com.example.onprop.config;

import com.example.onprop.model.MyPrototype;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.function.Function;

@Configuration
public class ServiceConfig {
    @Bean
    public Function<String, MyPrototype> myPrototypeFactory() {
        return name -> myPrototype(name);
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public MyPrototype myPrototype(String name) {
        return new MyPrototype(name);
    }
}
