package com.ayush.decorator;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.json.bind.JsonbBuilder;

@Priority(20)
@Decorator
public abstract class LogMessageJsonFormatter implements LogMessage {
    @Inject
    @Any
    @Delegate
    private LogMessage logMessage;

    public void printMessage()
    {
        String message = logMessage.getMessage();
        String jsonMessage = JsonbBuilder.create().toJson(message);
        logMessage.setMessage(jsonMessage);
    }
}
