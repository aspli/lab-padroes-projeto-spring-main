# Explorando Padrões de Projetos na Prática com Java
## Digital Innovation One
## GFT Start 5 Java

* Project: Maven Project;
* Language: Java 17;
* Spring Boot: 2.7.0;

* Dependencies:
- Spring Web
- Spring Data JPA
- H2 Database
- OpenFeign
- Lombok

Técnicas de Padrões de Projetos abordadas:
* Padrão Criacional: @Bean, @Autowired e Singleton
* Padrão Comportamental: @Service, @Repository e Strategy
* Padrão Estrutural: @RestController e Facade

Link para acesso:
Swagger: ``http://127.0.0.1:8080/swagger-ui.html``

Parâmetros Minimos para PlayLoad no POST:
``
{
    "nome": "strin",
    "ean": "string",
    "distribuidora": [
        {
            "nome": "string",
            "endereco": {
            "cep": "string"
            }
        }
    ]
} `` 


