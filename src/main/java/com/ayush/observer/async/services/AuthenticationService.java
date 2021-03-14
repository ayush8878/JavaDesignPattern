package com.ayush.observer.async.services;

import com.ayush.observer.async.Customer;
import com.ayush.observer.async.CustomerEvent;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;

public class AuthenticationService {
    public void createAuthenticationCredentials(@CustomerEvent(CustomerEvent.Type.ADD) @Priority (20) @Observes Customer customer)
    {
        //
    }
}
