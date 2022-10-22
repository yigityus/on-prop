package com.example.onprop.config;

import com.example.onprop.model.Wrapper;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import lombok.Builder;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Data
@Builder
@Component
public class TargetMapConfig {
    private Map<String, KubernetesClient> kubernetesClientMap;

    public KubernetesClient getClient(String target) {
        if (kubernetesClientMap.keySet().contains(target)) {
            return kubernetesClientMap.get(target);
        }
        var kubernetesClient = kubernetesClient(target);
        kubernetesClientMap.put(target, kubernetesClient);
        return kubernetesClient;
    }

    @SneakyThrows
    public KubernetesClient kubernetesClient(String target) {
        final var location =
                String.format("/home/grand/dev/oak/on-prop/src/main/resources/config-%s.yaml", target);
        var in = new FileInputStream(ResourceUtils.getFile(location));
        var config = Config.fromKubeconfig(new String(in.readAllBytes(), StandardCharsets.UTF_8));
        return new DefaultKubernetesClient(config);
    }

}
