package com.ayush.singleton;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * This class consists of a pool manager and can be used to get a new Object from pool
 */
@Singleton
@Startup
public class PoolManager {
    private Queue<Object> pooledObjects = new LinkedBlockingDeque<>(1_000);

    public PoolManager(){
        for(int i=0;i <= 1000 ;i++)
        {
            pooledObjects.offer(new Object());
        }
    }

    public void returnObject(Object object)
    {
        pooledObjects.offer(object);
    }

    public Object borrowObject()
    {
        return pooledObjects.poll();
    }
}
