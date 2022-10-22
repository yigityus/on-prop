package com.example.onprop.properties;

import com.example.onprop.model.CanKlusterType;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "can-kube-cluster")
public class CanKubeClusterProperties {
    private CanKlusterType type = CanKlusterType.LOCAL;
    private String kubeConfigUrl;
}
