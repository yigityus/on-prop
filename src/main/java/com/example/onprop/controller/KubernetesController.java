package com.example.onprop.controller;

import com.example.onprop.service.KubernetesClientFactory;
import com.example.onprop.service.KubernetesOperations;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class KubernetesController {

    private final KubernetesOperations kubernetesOperations;
    private final KubernetesClientFactory kubernetesClientFactory;

    @GetMapping("/secret")
    public Map<String, String> create(@RequestParam String name) {
        return kubernetesOperations.createSecret(name);
    }

    @GetMapping("/{cluster}/secret")
    public Map<String, String> createOnCluster(@RequestParam String name, @PathVariable String cluster) {
        kubernetesClientFactory.useCluster(cluster);
        return kubernetesOperations.createSecret(name);
    }



}
