package com.example.onprop.service;

import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class KubernetesOperations {

    private final KubernetesClient kubernetesClient;

    public Map<String, String> createSecret(String name) {
        Secret secret = new SecretBuilder().withNewMetadata()
                .withName(name)
                .withNamespace("neo4jtest")
                .endMetadata()
                .withStringData(new HashMap<>() {{
                    put("hello", "World!");
                }})
                .build();
        return kubernetesClient.secrets().create(secret).getData();
    }

}
