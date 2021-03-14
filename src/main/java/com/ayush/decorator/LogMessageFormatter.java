package com.ayush.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.time.LocalDate;

@Decorator
public abstract class LogMessageFormatter implements LogMessage {
    @Any
    @Delegate
    @Inject
    LogMessage logMessage;


    @Override
    public void printMessage() {
    String message = logMessage.getMessage();
    message = LocalDate.now().toString().concat(message);
    logMessage.setMessage(message);
    }
}
