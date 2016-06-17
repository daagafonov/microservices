package com.miratech.microservices.customers.rest;

import com.miratech.microservices.shared.model.Customer;
import com.miratech.microservices.shared.model.ObjectList;
import com.miratech.microservices.shared.util.Constants;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Component
@Path(Constants.CUSTOMERS_URL_PREFIX)
public class CustomerRestController {
    private static ObjectList<Customer> customers = new ObjectList<Customer>();

    static {
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setNome("Customer 1");
        customer1.setEmail("customer1@gmail.com");
        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setNome("Customer 2");
        customer2.setEmail("Customer2@gmail.com");
        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setNome("Customer 3");
        customer3.setEmail("Customer3@gmail.com");
        Customer customer4 = new Customer();
        customer4.setId(4);
        customer4.setNome("Customer 4");
        customer4.setEmail("Customer4@gmail.com");
        Customer customer5 = new Customer();
        customer5.setId(5);
        customer5.setNome("Customer 5");
        customer5.setEmail("Customer5@gmail.com");
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
    }

    @GET
    @Path("/*")
    @Produces(MediaType.APPLICATION_JSON)
    public ObjectList<Customer> getCustomers() {
        return customers;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@QueryParam("id") long id) {
        Customer cli = null;
        for (Customer c : customers.getList()) {
            if (c.getId() == id)
                cli = c;
        }
        return cli;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomerById(@PathParam("id") long id) {
        return getCustomer(id);
    }
}