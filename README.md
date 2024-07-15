Projeto Catalogo de Livros
Descrição
Este projeto é uma aplicação de catálogo de livros desenvolvida em Java com Spring Boot. A aplicação permite listar livros, buscar novos livros usando a API do Gutendex, e gerenciar informações sobre autores e livros. O projeto utiliza PostgreSQL como banco de dados.

Tecnologias Utilizadas
Java: Linguagem de programação
Spring Boot: Framework para desenvolvimento de aplicações Java
Spring Data JPA: Módulo do Spring para acesso a dados
PostgreSQL: Sistema de gerenciamento de banco de dados relacional
Gutendex API: API para busca de livros
Pré-requisitos
Java 21 ou superior
Maven 3.3.2 ou superior
PostgreSQL: Instalado e em execução
Postman ou qualquer outra ferramenta para testar APIs (opcional)
Configuração do Banco de Dados
Instale o PostgreSQL:

Baixe e instale o PostgreSQL a partir do site oficial.
Crie o Banco de Dados:

Abra o terminal ou a ferramenta de administração PostgreSQL e execute o comando para criar o banco de dados:
sql
Copy code
CREATE DATABASE catalogo;
Configure o Usuário e Senha:

Crie um usuário e defina uma senha para acessar o banco de dados:
sql
Copy code
CREATE USER seu_usuario WITH ENCRYPTED PASSWORD 'sua_senha';
GRANT ALL PRIVILEGES ON DATABASE catalogo TO seu_usuario;
Configuração do Projeto
Clone o Repositório:

bash
Copy code
git clone https://github.com/seuusuario/catalogo-livros.git
cd catalogo-livros
Configure as Propriedades do Aplicativo:

Abra o arquivo src/main/resources/application.properties e configure as propriedades do banco de dados:
properties
Copy code
spring.application.name=catalogo-livros
spring.datasource.url=jdbc:postgresql://localhost:5432/catalogo
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Configure as Dependências do Projeto:

Certifique-se de que o arquivo pom.xml contém as seguintes dependências:
xml
Copy code
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.7.3</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
Estrutura do Projeto
src/main/java/com/exemplo/catalogo/livros/model/Autor.java: Modelo de dados para autores.
src/main/java/com/exemplo/catalogo/livros/model/Livro.java: Modelo de dados para livros.
src/main/java/com/exemplo/catalogo/livros/repository/AutorRepository.java: Repositório JPA para autores.
src/main/java/com/exemplo/catalogo/livros/repository/LivroRepository.java: Repositório JPA para livros.
src/main/java/com/exemplo/catalogo/livros/service/LivroService.java: Serviço para gerenciamento de livros e autores.
src/main/java/com/exemplo/catalogo/livros/service/GutendexService.java: Serviço para integração com a API Gutendex.
src/main/java/com/exemplo/catalogo/livros/controller/LivroController.java: Controlador REST para operações relacionadas a livros.
src/main/resources/application.properties: Configurações do Spring Boot e do banco de dados.
Executando o Projeto
Compile e Construa o Projeto:

bash
Copy code
mvn clean install
Execute a Aplicação:

bash
Copy code
mvn spring-boot:run
A aplicação será iniciada e estará disponível no http://localhost:8080.

Testando a API
Listar Livros: GET /livros
Buscar e Salvar Livros: POST /livros/buscar?parametros={parametros}
