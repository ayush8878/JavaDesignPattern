package com.ayush.singleton;

import javax.inject.Inject;

public class UsePoolManager {

    @Inject
    private PoolManager poolManager;

    public void usePoolObject()
    {
        Object object = poolManager.borrowObject();
        poolManager.returnObject(object);
    }
}
