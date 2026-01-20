package com.example.kafka.services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.kafka.dto.PedidoEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoProducer {

    private final KafkaTemplate<String, PedidoEvent> kafkaTemplate;

    public void enviarPedido(PedidoEvent event) {
        kafkaTemplate.send("pedido-criado", event);
    }
}
