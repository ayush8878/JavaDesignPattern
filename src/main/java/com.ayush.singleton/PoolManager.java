package com.ayush.singleton;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * This class consists of a pool manager and can be used to get a new Object from pool
 */
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@DependsOn("Configuration")
@Singleton
@Startup
public class PoolManager {
    private Queue<Object> pooledObjects = new LinkedBlockingDeque<>(1_000);

    public PoolManager(){

    }

    /**
     * As this is a heavy operation this need not to be done always our container starts,instead it should be instantiated when dependency injection is invoked
     */
    @PostConstruct
    void constructExpensiveObjects()
    {
        for(int i=0;i <= 1000 ;i++)
        {
            pooledObjects.offer(new Object());
        }
    }

    @AccessTimeout(value = 30,unit = TimeUnit.SECONDS )
    @Lock(LockType.WRITE)
    public void returnObject(Object object)
    {
        pooledObjects.offer(object);
    }

    @Lock(LockType.READ)
    public Object borrowObject()
    {
        return pooledObjects.poll();
    }
}
