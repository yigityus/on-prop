package com.example.onprop.config;

import com.example.onprop.model.Wrapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
public class TargetConfig implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,
            proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Wrapper wrapper() {
        return new Wrapper();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void wrapTarget(String target) {
        ConfigurableBeanFactory configurableBeanFactory = (ConfigurableBeanFactory) beanFactory;
        configurableBeanFactory.destroyBean("wrapper", configurableBeanFactory.getBean("wrapper"));
        configurableBeanFactory.registerSingleton("wrapper", new Wrapper(target));
    }

}
