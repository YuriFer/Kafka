package com.example.kafka.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.dto.PedidoEvent;
import com.example.kafka.services.PedidoProducer;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoProducer producer;

    @PostMapping
    public ResponseEntity<String> criarPedido(@RequestBody PedidoEvent event) {
        producer.enviarPedido(event);
        return ResponseEntity.ok("Pedido enviado para o Kafka");
    }
}
