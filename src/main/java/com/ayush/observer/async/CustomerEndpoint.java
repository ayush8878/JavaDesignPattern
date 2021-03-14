package com.ayush.observer.async;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.event.NotificationOptions;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ForkJoinPool;

@Stateless
@Path("/customers")
public class CustomerEndpoint {

    @Inject
    @CustomerEvent(CustomerEvent.Type.ADD)
    private Event<Customer> customerAddEvent;

    @Inject
    @CustomerEvent(CustomerEvent.Type.REMOVE)
    private Event<Customer> customerRemoveEvent;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void newCustomer(Customer customer)
{
    // in a scenario where there are less than 10 observers they all can get executed simultaneously
    // others must wait
    CompletionStage<Customer> completionStage = customerAddEvent.fireAsync(customer, NotificationOptions.ofExecutor(new ForkJoinPool(10)));
    // incase execptions occured then they all can be handled here
    completionStage.handle((Customer event,Throwable ex )->
    {
       for(Throwable t: ex.getSuppressed() )
       {
           //log
       }
       return event;
    }
    );
}
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteCustomer(Customer customer)
    {
        customerRemoveEvent.fireAsync(customer);
    }
}
