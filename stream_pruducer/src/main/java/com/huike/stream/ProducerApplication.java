package com.huike.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@EnableBinding(Source.class)
public class ProducerApplication implements CommandLineRunner {
    @Autowired
    MessageChannel output;

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class);
    }

    public void run(String... strings) throws Exception {
        output.send(MessageBuilder.withPayload("hello world").build());
    }
}
