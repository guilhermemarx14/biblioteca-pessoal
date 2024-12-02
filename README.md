# Biblioteca pessoal

Bem-vindo ao projeto **Biblioteca pessoal**, uma aplicação desenvolvida com **Spring MVC** para que meu pai possa organizar o catálogo de livros que
ele possui.

## 📜 Sobre o Projeto

Este projeto tem como objetivo criar um sistema que permite:

- Cadastrar itens da coleção (livros).
- Gerenciar informações detalhadas de cada item (autores, gêneros, datas, avaliações, etc.).
- Visualizar resumos, estatísticas e categorias.
- Pesquisar e filtrar itens com base em critérios específicos.

## 🚀 Tecnologias Utilizadas

- **Java** (JDK 21)
- **Spring Framework** (Spring Boot, Spring MVC, Spring Data JPA)
- **Banco de Dados**: hsqldb
- **Template Engine**: Thymeleaf
- **Front-end**: Bootstrap, w3s e CSS personalizado
- **Bibliotecas Auxiliares**:
    - Google Truth (para testes)
    - Lombok (para reduzir boilerplate)

## 📁 Estrutura do Projeto

O projeto segue a arquitetura **MVC**:

```plaintext
src/main/java/com/poxete/biblioteca_pessoal/
│
├── config/            # Configurações e classes de configuração
├── controller/        # Controladores de front-end
├── exception/         # Tratamento de exceptions personalizadas
├── model/             # Classes de domínio
├── model/mapper/      # Conversão entre entidades e DTOs
├── repository/        # JPARepositories
├── service/           # Camada de serviços
├── service/cllient    # Clients de comunicação com outras APIs
├── usecase/           # Casos de uso - implementam a lógica da aplicação
└── utils/             # Classes utilitárias
```

## 📄 Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](./LICENSE) para mais detalhes.


