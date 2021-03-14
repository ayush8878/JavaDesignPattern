package com.ayush.observer.sync.services;

import com.ayush.observer.sync.Customer;
import com.ayush.observer.sync.CustomerEvent;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;

public class EmailService {

    public void sendWelcomeEmail( @CustomerEvent(CustomerEvent.Type.ADD) @Priority (1000) @Observes Customer customer)
    {
        // send mail
    }
}
