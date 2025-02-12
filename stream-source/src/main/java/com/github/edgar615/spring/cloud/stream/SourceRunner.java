package com.github.edgar615.spring.cloud.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class SourceRunner implements ApplicationRunner {

    @Autowired
    private UserChangeSource userChangeSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userChangeSource.publish("user");
        TimeUnit.SECONDS.sleep(3);
    }
}
