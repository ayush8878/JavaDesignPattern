package com.ayush.observer.async.services;

import com.ayush.observer.async.Customer;
import com.ayush.observer.async.CustomerEvent;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;

public class EmailService {

    public void sendWelcomeEmail( @CustomerEvent(CustomerEvent.Type.ADD) @Priority (1000) @Observes Customer customer)
    {
        // send mail
    }
}
