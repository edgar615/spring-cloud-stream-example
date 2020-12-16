package com.github.edgar615.example.spring.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class CustomExceptionHandler implements ConsumerAwareListenerErrorHandler {

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer) {
        StringBuffer logOutput = new StringBuffer();
        logOutput.append("cosume a message failed")
                .append(" , payload='")
                .append(message.getPayload())
                .append("'");
        System.out.println(logOutput);
        return null;
    }
}
