package com.example.onprop.config;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import lombok.SneakyThrows;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

@Configuration
public class KubernetesClientConfig {

    @SneakyThrows
    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public KubernetesClient kubernetesClient(String cluster) {
        final var location =
                String.format("/home/grand/dev/oak/on-prop/src/main/resources/config-%s.yaml", cluster);
        var in = new FileInputStream(ResourceUtils.getFile(location));
        var config = Config.fromKubeconfig(new String(in.readAllBytes(), StandardCharsets.UTF_8));
        return new DefaultKubernetesClient(config);
    }


}
