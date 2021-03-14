package com.ayush.observer.sync.services;

import com.ayush.observer.sync.Customer;
import com.ayush.observer.sync.CustomerEvent;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;

public class CustomerService {


    public void createCustomer(@CustomerEvent(CustomerEvent.Type.ADD) @Observes @Priority(10) Customer customer)
    {
        //create customer

    }

    public void deleteCustomer(@CustomerEvent(CustomerEvent.Type.REMOVE) @Observes @Priority(10) Customer customer)
    {
        //delete customer
    }
}
