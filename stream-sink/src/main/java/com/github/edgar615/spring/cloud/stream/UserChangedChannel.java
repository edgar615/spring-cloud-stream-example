package com.github.edgar615.spring.cloud.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface UserChangedChannel {
    @Input("UserChangedChannel")
    SubscribableChannel userChangedChannel();
}
