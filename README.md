
## Cmds

### Docker Up
```agsl
docker compose up -d
```

## Portals
1. [Eureka](http://localhost:8761/)
1. [PGAdmin](http://localhost:5050/browser/)
1. [Zipkin](http://127.0.0.1:9411/)
1. [RabbitMQ](http://localhost:15672/)


# Docker
```agsl
 mvn clean package -P build-docker-image
```