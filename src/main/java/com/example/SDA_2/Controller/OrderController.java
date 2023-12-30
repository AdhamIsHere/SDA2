package com.example.SDA_2.Controller;

import com.example.SDA_2.Data.OrdersDatabase;
import com.example.SDA_2.Models.*;
import com.example.SDA_2.Models.Order.CompoundOrder;
import com.example.SDA_2.Models.Order.SimpleOrder;
import com.example.SDA_2.Services.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderServiceImp orderServiceImp;
    @PostMapping("/create/simple")
    public Response createSimpleOrder(@RequestBody SimpleOrder o){
        Response res = new Response();
        if(CustomerController.loggedin == null){
            res.setStatus(false);
            res.setMessage("Must Login First");
            return res;
        }
       res = orderServiceImp.createOrder(o);

        return res;
    }
    @PostMapping("/create/compound")
    public Response createCompoundOrder(@RequestBody CompoundOrder o){
        Response res = new Response();
        if(CustomerController.loggedin == null){
            res.setStatus(false);
            res.setMessage("Must Login First");
            return res;
        }
        return res;
    }
}