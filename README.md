# Test Java Developer - Digisystem

### Desafio 01
Desenvolva uma api Rest em Spring para receber como parâmetro JSON's no
seguinte formato:
{
"acao": "soma",
"numeros": [5,4,3,2,1]
}
E deve retornar um JSON com a seguinte assinatura, com no máximo 2 casas
decimais:
{
"total": 15.00
}

#### - chl01
* Descrição     : Realizar opções de cálculo (soma, subtrai, média e total)
* URL padrão    : http://localhost:9077/test/chl01
* Método        : POST
* Parametros    : {
                "acao": "<opções>",
                "numeros": [5,4,3,2,1]
                }
                
### Desafio 02
Desenvolva uma api em spring para receber como parameto os seguintes os JSON`s
no seguinte formato:
{
    "pessoa":{
    "nome":"James Gosling",
    "idade":55,
    "salario": 1000.00
    }
}

#### - chl02Save
* Descrição     : Gravar os dados na base (MONGODB)
* URL padrão    : http://localhost:9077/test/chl02Save
* Método        : POST
* Parametros    : {
                      "pessoa":{
                      "nome":"James Gosling",
                      "idade":55,
                      "salario": 1000.00
                      }
                  }

#### - cchl02FindAll
* Descrição     : Listar todas as pessoas cadastradas
* URL padrão    : http://localhost:9077/test/chl02FindAll
* Método        : GET
* Parametros    : Nenhum

#### - chl02FindPersonById
* Descrição     : Listar pessoa pelo ID
* URL padrão    : http://localhost:9077/test/chl02FindPersonById
* Método        : GET
* Parametros    : Id do cliente

#### - chl02FindPersonByName
* Descrição     : Listar pessoa pelo Nome
* URL padrão    : http://localhost:9077/test/chl02FindPersonByName
* Método        : GET
* Parametros    : Nome

#### - chl02FindPersonBySalary
* Descrição     : Listar pessoa pelo Salário
* URL padrão    : http://localhost:9077/test/chl02FindPersonBySalary
* Método        : GET
* Parametros    : Salário

#### - chl02UpdatePerson
* Descrição     : Alterar as informacoes da pessoa pelo nome ou ID.
* URL padrão    : http://localhost:9077/test/chl02UpdatePerson
* Método        : POST
* Parametros    : {
                  "typeKeyToUpdate":<tipo = 0 para ID ou Tipo = 1 para Nome>,
                  "keyToUpdate": "<valor a pesquisar>",
                  "pessoa":{
                      "nome":"Walter Ribeiro da Silva",
                      "idade":53,
                      "salario": 10000.00
                      }
                  }

### Informações adcionais
Para testar esse microserviço será necessário executar os seguintes passos:
- Configurar as variaveis de acesso ao Mongodb no arquivo application.properties
- Ter uma versão do docker instalada
- Para ativar o microserviço, executar o sequinte comando (testado no ambiente UBUNTU): 
    - sudo ./start.sh test 9077
- Verificar se o microserviço esta ativo:
    http://localhost:9077/test/isOnline
- Para desativar o microserviço, executar o sequinte comando (testado no ambiente UBUNTU): 
    - sudo ./stop.sh test


