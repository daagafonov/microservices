package com.miratech.microservices.orders;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        this.packages(Application.class.getPackage().getName());
    }
}
