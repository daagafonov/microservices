package com.miratech.microservices.orders.rest;

import com.miratech.microservices.orders.CustomerService;
import com.miratech.microservices.orders.ProductService;
import com.miratech.microservices.shared.model.Customer;
import com.miratech.microservices.shared.model.Order;
import com.miratech.microservices.shared.model.Product;
import com.miratech.microservices.shared.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Component
@Path(Constants.ORDERS_URL_PREFIX)
public class OrderRestController {

    private long id = 1;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Order submitOrder(@QueryParam("idCustomer") long idCustomer,
                             @QueryParam("idProduct") long idProduct,
                             @QueryParam("amount") long amount) {
        Order order = new Order();

        Product p = productService.getProductById(String.valueOf(idProduct));
        Customer c = customerService.getCustomerById(idCustomer);

        order.setProduct(p);
        order.setCustomer(c);
        order.setId(id);
        order.setAmount(amount);
        order.setDateOrder(new Date());
        id++;

        return order;
    }

}
