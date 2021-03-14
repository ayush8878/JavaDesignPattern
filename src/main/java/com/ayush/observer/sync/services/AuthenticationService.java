package com.ayush.observer.sync.services;

import com.ayush.observer.sync.Customer;
import com.ayush.observer.sync.CustomerEvent;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;

public class AuthenticationService {
    public void createAuthenticationCredentials(@CustomerEvent(CustomerEvent.Type.ADD) @Priority (20) @Observes Customer customer)
    {
        //
    }
}
