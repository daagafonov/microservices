package com.miratech.microservices.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class Application {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "orders-server");
        SpringApplication.run(Application.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ProductService productService() {
        return new ProductService("http://PRODUCTS-SERVICE");
    }

    @Bean
    public CustomerService customerService() {
        return new CustomerService("http://CUSTOMERS-SERVICE");
    }

}