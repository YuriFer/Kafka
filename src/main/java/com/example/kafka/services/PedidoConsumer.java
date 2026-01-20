package com.example.kafka.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.kafka.dto.PedidoEvent;

@Service
public class PedidoConsumer {

    @KafkaListener(topics = "pedido-criado", groupId = "pedido-group")
    public void consumir(PedidoEvent event) {
        System.out.println("Pedido recebido: " + event);
    }
}