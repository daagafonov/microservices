package com.miratech.microservices.orders;

import com.miratech.microservices.shared.model.Customer;
import com.miratech.microservices.shared.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    private String serviceUrl;

    public CustomerService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
    }

    public Customer getCustomerById(long id) {
        return restTemplate.getForObject(serviceUrl + "/" + Constants.CUSTOMERS_URL_PREFIX + "/{id}", Customer.class, id);
    }

}
