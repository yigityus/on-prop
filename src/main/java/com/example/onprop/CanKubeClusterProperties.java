package com.example.onprop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "can-kube-cluster")
public class CanKubeClusterProperties {
    private CanKlusterType type = CanKlusterType.LOCAL;
    private String kubeConfigUrl;
}
