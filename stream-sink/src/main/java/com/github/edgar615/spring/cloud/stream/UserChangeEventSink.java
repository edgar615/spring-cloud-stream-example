package com.github.edgar615.spring.cloud.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@EnableBinding(UserChangedChannel.class)
//@Component
public class UserChangeEventSink {

    @StreamListener("UserChangedChannel")
    public void handle(UserChangedEvent userChangedEvent) {
        System.out.println(userChangedEvent);
    }
}
