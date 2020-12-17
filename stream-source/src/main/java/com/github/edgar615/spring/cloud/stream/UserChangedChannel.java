package com.github.edgar615.spring.cloud.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface UserChangedChannel {
    @Output("UserChangedChannel")
    MessageChannel userChangedChannel();
}
