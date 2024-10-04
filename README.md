# **Horizontes Travel - Sistema de Agência de Viagens**

## Descrição

O **Horizontes Travel** é um sistema de gerenciamento de uma agência de viagens desenvolvido utilizando Java Swing para a interface gráfica e MySQL como banco de dados. O sistema permite que os usuários gerenciem reservas, cadastrem pessoas, pacotes turísticos e destinos. Ele foi projetado como projeto na disciplina de POO, oferecendo uma interface amigável e eficiente para a manipulação de dados dos clientes e pacotes turísticos.

Este projeto foi desenvolvido por Wesnei e João Lucas como parte de um estudo prático em desenvolvimento de software, abordando as tecnologias Java para front-end e MySQL para back-end.

## Funcionalidades

- **Gerenciamento de Reservas**: Criar, visualizar, editar e excluir reservas de viagens.
- **Cadastro de Pessoas**: Inserção, atualização e remoção de clientes.
- **Cadastro de Pacotes Turísticos**: Gerenciamento dos pacotes turísticos oferecidos pela agência.
- **Cadastro de Destinos**: Gerenciamento dos destinos disponíveis para os pacotes turísticos.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal para o desenvolvimento da interface gráfica (utilizando Swing).
- **MySQL**: Banco de dados relacional utilizado para armazenar as informações de reservas, clientes, pacotes e destinos.
- **Git/GitHub**: Controle de versão e hospedagem do código-fonte.
  
## Requisitos

- **JDK 11+** (ou superior) para compilar e rodar a aplicação Java.
- **MySQL** para banco de dados (versão 8.0 ou superior).
- **IDE Java** (como IntelliJ IDEA, Eclipse ou NetBeans) para desenvolvimento e execução.
- **Git** para clonar o repositório.

## Instalação e Configuração

1. **Clone o repositório**:
    ```bash
    git clone https://github.com/SeuUsuario/Agencia_viagens.git
    cd Agencia_viagens
    ```

2. **Configure o banco de dados MySQL**:
    - Crie o banco de dados para o sistema:
      ```sql
      CREATE DATABASE travel_schema;
      ```

3. **Configure a conexão com o banco de dados**:
    - No arquivo `MyJDBC.java` ou onde estiver configurado, defina os parâmetros de conexão:
      ```properties
      db.url=jdbc:mysql://localhost:3306/travel_schema
      db.user=seu_usuario
      db.password=sua_senha
      ```

4. **Compile e execute a aplicação**:
    - Se estiver utilizando uma IDE, importe o projeto e execute a classe principal `TelaInicial.java`.
    - Se preferir usar a linha de comando:
      ```bash
      javac -cp .:mysql-connector-java-8.0.23.jar TelaInicial.java
      java -cp .:mysql-connector-java-8.0.23.jar TelaInicial
      ```


## Colaboradores

- **Wesnei** - Desenvolvedor Front-End e Designer da Interface Gráfica.
  - GitHub:(https://github.com/Wesnei)
  - E-mail: wesneipaiva@gmail.com
  - Linkedln: (https://www.linkedin.com/in/wesnei-paiva-98539a292/)

- **João Lucas** - Desenvolvedor Back-end e integração com banco de dados.
  - GitHub:(https://github.com/Joaol324j)
  - E-mail: joaol324j@gmail.com
  - Linkedln: (https://www.linkedin.com/in/jo%C3%A3o-lucas-carvalho-jacinto-069522270/)


## Licença

Este projeto é licenciado sob os termos da licença MIT. Veja o arquivo `LICENSE` para mais detalhes.


