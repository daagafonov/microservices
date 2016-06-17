package com.miratech.microservices.orders;

import com.miratech.microservices.shared.model.Product;
import com.miratech.microservices.shared.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    private String serviceUrl;

    public ProductService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
    }

    public Product getProductById(String productId) {
        return restTemplate.getForObject(serviceUrl + "/" + Constants.PRODUCTS_URL_PREFIX + "/{id}", Product.class, productId);
    }

}
