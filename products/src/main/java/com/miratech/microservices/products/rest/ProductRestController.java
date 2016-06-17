package com.miratech.microservices.products.rest;

import com.miratech.microservices.shared.model.ObjectList;
import com.miratech.microservices.shared.model.Product;
import com.miratech.microservices.shared.util.Constants;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Component
@Path(Constants.PRODUCTS_URL_PREFIX)
public class ProductRestController {

    private static ObjectList<Product> products = new ObjectList<Product>();

    static {
        Product product1 = new Product();
        product1.setId(1);
        product1.setSku("abcd1");
        product1.setDescription("Product1");
        Product product2 = new Product();
        product2.setId(2);
        product2.setSku("abcd2");
        product2.setDescription("Product2");
        Product product3 = new Product();
        product3.setId(3);
        product3.setSku("abcd3");
        product3.setDescription("Product3");
        Product product4 = new Product();
        product4.setId(4);
        product4.setSku("abcd4");
        product4.setDescription("Product4");
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
    }

    @GET
    @Path("/*")
    @Produces(MediaType.APPLICATION_JSON)
    public ObjectList<Product> getProducts() {
        return products;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@QueryParam("id") long id) {
        Product prod = null;
        for (Product p : products.getList()) {
            if (p.getId() == id)
                prod = p;
        }
        return prod;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProductById(@PathParam("id") long id) {
        return getProduct(id);
    }

}
