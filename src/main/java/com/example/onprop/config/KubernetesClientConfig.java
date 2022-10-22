package com.example.onprop.config;

import com.example.onprop.model.Wrapper;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

@Slf4j
@Configuration
public class KubernetesClientConfig {

    @SneakyThrows
    @Bean
    public KubernetesClient kubernetesClient(Wrapper wrapper) {

        if (wrapper.getTarget() == null) {
            return new DefaultKubernetesClient();
        }

        final var location =
                String.format("/home/grand/dev/oak/on-prop/src/main/resources/config-%s.yaml", wrapper.getTarget());
        var in = new FileInputStream(ResourceUtils.getFile(location));
        var config = Config.fromKubeconfig(new String(in.readAllBytes(), StandardCharsets.UTF_8));
        return new DefaultKubernetesClient(config);
    }

}
