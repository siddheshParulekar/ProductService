package com.hft.product.kafka;

import com.hft.product.request.ProductRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaListner {


    @KafkaListener(topics = "my_topic", groupId = "my-group")
    public void getSellRequest(@Payload ProductRequest productRequest){
        try {
            // Your business logic here
            System.out.println("Received message: " + productRequest.toString());
        } catch (Exception e) {
            System.err.println("Failed to process message: " + e.getMessage());
        }
    }
}
