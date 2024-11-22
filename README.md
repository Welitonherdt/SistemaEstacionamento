API Estacionamento
API para gerenciar estacionamento de veículos, vagas e clientes.
Sumário
•	Pré-requisitos
•	Instalação
•	Configuração do Banco de Dados
•	Execução
•	Ordem de Requisições
•	Testes no Postman
•	Documentação
________________________________________
Pré-requisitos
•	Java 17 ou superior
•	Maven (para gerenciamento de dependências)
•	PostgreSQL (banco de dados)
Instalação
1.	Clonar o repositório:
2.	git clone <URL_DO_REPOSITORIO_GIT>
cd SistemaEstacionamento
3.	Instalar dependências:
mvn clean install
Configuração do Banco de Dados
1.	Inicie o PostgreSQL e crie o banco de dados:
CREATE DATABASE estacionamento;
2.	(Opcional) Crie um usuário específico para o projeto:
3.	CREATE USER estacionamento_user WITH PASSWORD 'sua_senha';
ALTER DATABASE estacionamento OWNER TO estacionamento_user;
4.	Configure as credenciais no arquivo src/main/resources/application.properties:
5.	spring.datasource.url=jdbc:postgresql://localhost:5432/estacionamento
6.	spring.datasource.username=seu nome
7.	spring.datasource.password=sua_senha
Execução
Para rodar o projeto, execute o seguinte comando no terminal:
mvn spring-boot:run
A aplicação estará disponível em: http://localhost:8080.
________________________________________
Ordem de Requisições
Para evitar erros de relacionamento ao usar a API, siga esta ordem para as requisições POST:
Em negrito esta cada campo da tabela especifica.

1.	Vagas:
o	Crie as vagas primeiro.
2.	{
3.	  "codigo": 0,
4.	  "dataCriacao": "2024-11-18T23:07:23.683Z",
5.	  "dataAtualizacao": "2024-11-18T23:07:23.683Z",
6.	  "localizacao": "string",
7.	  "tipo": "string"
8.	}
9.	Clientes:
o	Crie os clientes que estará relacionado com veiculos.
10.	{
11.	  "codigo": 0,
12.	  "nome": "string",
13.	  "telefone": "string",
14.	  "endereco": "string",
15.	  "email": "string
16.	}



17.	Veiculos:
o	Crie os veículos eles estão relacionados com os clientes.
18.	{
19.	  "codigo": 1,
20.	  "marca": "string",
21.	  "modelo": "string",
22.	  "anoFabricacao": "2024-11-18T23:08:35.307Z",
23.	  "cor": "string",
24.	  "placa": "string",
25.	  "proprietario": {
26.	    "codigo": 1,
27.	    "nome": "string",
28.	    "telefone": "string",
29.	    "endereco": "string",
30.	    "email": "string"
31.	  }
32.	}
33.	Ticket:
o	Crie tickets, que estará relacionado com todas exceto com pagameto
34.	{
35.	  "codigo": 0,
36.	  "dataCriacao": "2024-11-18T23:12:04.846Z",
37.	  "dataAtualizacao": "2024-11-18T23:12:04.846Z",
38.	  "status": "string",
39.	  "prioridade": "string",
40.	  "cliente": {
41.	    "codigo": 1,
42.	    "nome": "string",
43.	    "telefone": "string",
44.	    "endereco": "string",
45.	    "email": "string"
46.	  },
47.	  "veiculo": {
48.	    "codigo": 1,
49.	    "marca": "string",
50.	    "modelo": "string",
51.	    "anoFabricacao": "2024-11-18T23:12:04.846Z",
52.	    "cor": "string",
53.	    "placa": "string",
54.	    "proprietario": {
55.	      "codigo": 0,
56.	      "nome": "string",
57.	      "telefone": "string",
58.	      "endereco": "string",
59.	      "email": "string"
60.	    }
61.	  },
62.	  "vaga": {
63.	    "codigo": 1,
64.	    "dataCriacao": "2024-11-18T23:12:04.846Z",
65.	    "dataAtualizacao": "2024-11-18T23:12:04.846Z",
66.	    "localizacao": "string",
67.	    "tipo": "string"
68.	  }
69.	}
70.	Pagamento:
o	Registre os pagamentos que estará relacionado a todos os outros.
o	{
o	  "codigo": 1,
o	  "valor": 10,
o	  "dataPagamento": "2024-11-18T23:14:01.247Z",
o	  "status": "string",
o	  "formaPagamento": "string",
o	  "email": "string",
o	  "ticket": {
o	    "codigo": 1,
o	    "dataCriacao": "2024-11-18T23:14:01.247Z",
o	    "dataAtualizacao": "2024-11-18T23:14:01.247Z",
o	    "status": "string",
o	    "prioridade": "string",
o	    "cliente": {
o	      "codigo": 1,
o	      "nome": "string",
o	      "telefone": "string",
o	      "endereco": "string",
o	      "email": "string"
o	    },
o	    "veiculo": {
o	      "codigo": 1,
o	      "marca": "string",
o	      "modelo": "string",
o	      "anoFabricacao": "2024-11-18T23:14:01.247Z",
o	      "cor": "string",
o	      "placa": "string",
o	      "proprietario": {
o	        "codigo": 0,
o	        "nome": "string",
o	        "telefone": "string",
o	        "endereco": "string",
o	        "email": "string"
o	      }
o	    },
o	    "vaga": {
o	      "codigo": 0,
o	      "dataCriacao": "2024-11-18T23:14:01.247Z",
o	      "dataAtualizacao": "2024-11-18T23:14:01.247Z",
o	      "localizacao": "string",
o	      "tipo": "string"
o	    }
o	  }
o	}
________________________________________
Testes no Postman
1.	Importe a documentação da API no Postman usando a URL do OpenAPI (Swagger):
2.	http://localhost:8080/api-docs.json
3.	Configure a variável {{base_url}} como http://localhost:8080 para facilitar o uso dos endpoints.
4.	Execute as requisições seguindo a ordem definida acima para evitar erros de relacionamento.
________________________________________
Documentação
A documentação completa da API é gerada automaticamente pelo Swagger e pode ser acessada em:
http://localhost:8080/docs

