# Explorando Padrões de Projetos na Prática com Java
## Digital Innovation One e GFT Start 5 Java
## Implementado Caso de Uso: Livro e Livraria, consumindo a API ViaCep para alimentor os endereços em Livraria.

### Project: Maven Project;
### Language: Java 17;
### Spring Boot: 2.7.0;

### Dependencies:
- Spring Web
- Spring Data JPA
- H2 Database
- OpenFeign

### Técnicas de Padrões de Projetos abordadas:
* Padrão Criacional: @Bean, @Autowired e Singleton
* Padrão Comportamental: @Service, @Repository e Strategy
* Padrão Estrutural: @RestController e Facade

### Link para acesso:
Swagger: ``http://127.0.0.1:8080/swagger-ui.html``

### Parâmetros Minimos para PlayLoad no POST:
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

### Exemplo para Post:
``
{
    "nome": "Design Patterns: Elements of Reusable Object-Oriented Software",
    "isbn": "9780201633610",
    "autor": "Erich Gamma, Richard Helm, Ralpah Johnson, John M. Vlissides",
    "livrarias": [
    {
        "nome": "Saraiva",
        "endereco": {
        "cep": "15285000"        
              },
              "numeroEndereco": 11
            }
    ]
} ``

