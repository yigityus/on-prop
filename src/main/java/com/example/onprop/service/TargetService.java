package com.example.onprop.service;

import com.example.onprop.config.TargetMapConfig;
import io.fabric8.kubernetes.client.KubernetesClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class TargetService {
    private final KubernetesOperations kubernetesOperations;
    private final TargetMapConfig targetMapConfig;

    public Map<String, String> createOnCluster(String name, String target) {
        KubernetesClient kubernetesClient = targetMapConfig.getClient(target);
        return kubernetesOperations.createSecret(kubernetesClient, name);
    }

}
