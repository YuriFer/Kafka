package com.example.kafka.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoEvent {
    private String pedidoId;
    private String cliente;
    private BigDecimal valor;
}