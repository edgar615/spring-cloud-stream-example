package com.github.edgar615.spring.cloud.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class UserChangeSource {

//    @Autowired
//private Source source;
//    @Output("UserChangedChannel")
//    private MessageChannel output;
    @Autowired
    private UserChangedChannel changedChannel;


    public void publish(String username) {
        for (int i = 0; i < 10; i ++) {
            UserChangedEvent event = new UserChangedEvent();
            event.setType("UserChangedEvent");
            event.setOperation("add");
            User user = new User();
            user.setId(i);
            user.setUsername("edgar");
            event.setUser(user);
//        source.output().send(MessageBuilder.withPayload(event).build());
            changedChannel.userChangedChannel().send(MessageBuilder.withPayload(event).build());
        }
    }
}
