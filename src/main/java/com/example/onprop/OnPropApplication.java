package com.example.onprop;

import com.example.onprop.properties.CanKubeClusterProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CanKubeClusterProperties.class)
@RequiredArgsConstructor
@Slf4j
public class OnPropApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnPropApplication.class, args);
    }

    private final CanKubeClusterProperties kubeClusterProperties;


    @ConditionalOnProperty(prefix = "kube", name = "config-remote.yaml-source", havingValue = "aws-secrets-manager")
    @Bean
    public String on() {
        System.out.println("on ********************");
        return "";
    }

    @Bean
    ApplicationRunner runner() {
        return args -> {
            log.info(kubeClusterProperties.getType().name());
        };
    }

}
