# 🚀 Kafka Playground

Um projetinho simples pra brincar com Apache Kafka usando Spring Boot. A ideia aqui é ter um ambiente prático pra testar configurações, entender como producers e consumers funcionam, e ter algo rodando rapidinho pra experimentar.

---

## 💡 O que esse projeto faz?

Basicamente, simula um sistema de pedidos onde:

1. Você faz um POST com os dados de um pedido
2. O **Producer** joga essa mensagem no Kafka
3. O **Consumer** fica escutando e processa quando chega

Nada muito elaborado — é só pra aprender mesmo!

---

## 🛠️ Tech Stack

| Tecnologia | Versão |
|------------|--------|
| Java | 17+ |
| Spring Boot | 4.0.1 |
| Spring Kafka | 4.0.1 |
| Apache Kafka | 7.5.0 (Confluent) |
| Docker | Para subir o Kafka local |
| Lombok | Porque a vida é curta |

---

## 📁 Estrutura do Projeto

```
src/main/java/com/example/kafka/
├── KafkaApplication.java      # Main
├── controllers/
│   └── PedidoController.java  # Endpoint REST
├── dto/
│   └── PedidoEvent.java       # Objeto que trafega no Kafka
├── services/
│   ├── PedidoProducer.java    # Envia mensagens pro Kafka
│   └── PedidoConsumer.java    # Escuta e processa mensagens
└── docker/
    └── docker-compose.yml     # Kafka + Zookeeper
```

---

## 🐳 Subindo o Kafka com Docker

Antes de rodar a aplicação, você precisa do Kafka no ar. Entra na pasta do docker-compose e roda:

```bash
cd src/main/java/com/example/kafka/docker
docker-compose up -d
```

Isso vai subir:
- **Zookeeper** na porta `2181`
- **Kafka** na porta `9092`

Pra verificar se tá tudo ok:
```bash
docker-compose ps
```

---

## ▶️ Rodando a Aplicação

Com o Kafka rodando, é só mandar:

```bash
mvn spring-boot:run
```

A aplicação sobe na porta `8080` por padrão.

---

## 📮 Testando

Manda um POST pro endpoint `/pedidos`:

```bash
curl -X POST http://localhost:8080/pedidos \
  -H "Content-Type: application/json" \
  -d '{
    "pedidoId": "123",
    "cliente": "João",
    "valor": 99.90
  }'
```

Se tudo der certo, você vai ver no console da aplicação:

```
Pedido recebido: PedidoEvent(pedidoId=123, cliente=João, valor=99.90)
```

---

## ⚙️ Configurações

As configs do Kafka ficam no `application.properties`:

```properties
# Servidor do Kafka
spring.kafka.bootstrap-servers=localhost:9092

# Consumer
spring.kafka.consumer.group-id=pedido-group
spring.kafka.consumer.auto-offset-reset=earliest

# Serialização JSON pra Producer e Consumer
spring.kafka.producer.value-serializer=org.springframework.kafka.support.serializer.JsonSerializer
spring.kafka.consumer.value-deserializer=org.springframework.kafka.support.serializer.JsonDeserializer
```

## 🤝 Contribuindo

É um projeto de estudo, então se quiser sugerir algo ou melhorar, fica à vontade!

---
