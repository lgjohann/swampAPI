# API do aplicativo de agendamnto da Swamp Studio

A arquitetura da API é dada por:

![arquitetura da api swamp](https://github.com/user-attachments/assets/da5d5625-133b-41e9-8fef-5adfbd63de46)


## endpoints
GET
/agendamentos | Traz todos os agendamentos cadastrados no banco.


GET /agendamentos/{id} | Traz um agendamento específico identificado pelo ID passado.

POST /agendamentos | Insere um novo agendamento, model de dados conforme src/main/java/com/johann/swampAPI/domain

PUT /agendamentos/{id} | Atualiza um agendamento identificado pelo ID passado no request.

DELETE /agendamentos/{id} | Deleta um agendamento identificado pelo ID.


## Como rodar a API localmente

Informar uma string de conexão de banco de dados mongoDB (local ou Atlas (nuvem)) em src/main/resources/application.properties no parâmetro: spring.data.mongodb.uri

Utilizar um aplicativo para testes de requisições no localhost, nesse projeto eu utilizei Postman.
