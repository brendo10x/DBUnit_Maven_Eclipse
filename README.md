DBUnit_Maven_Eclipse
====================

Exemplo simples de como utilizar o DBUnit com maven e eclipse, exemplificando com um teste simples.

O teste proposto mostra o poder do DBUnit onde ele proporciona um maior conforto na hora de testar registros no banco de dados, neste exemplo o banco de dados contém somente 1 registro em produção, quando o teste é executado o DBUnit carrega os dados em XML(dbunitData.xml) para o banco de dados, que agora contém 2 registros, logo depois a operação é executada e testada como dos dados carregados, depois do teste os dados são apagados automaticamente voltando agora com 1 registro em produção, eliminando assim a contaminação de registros de teste e o esforço do programador de excluir os dados, mantendo o estado atual do banco de dados.

Requisitos

- 1 - Maven configurado na ide eclipse (update project..)
- 2 - Criar um banco de dados chamado "dbunit_banco" ou outro qualquer.
- 3 - Importar o arquivo "dbunit_banco.sql" que está na raiz deste projeto para o banco de dados informado.
- 4 - Configurar o metodo getConnection() da classe CalculadoraSalarioTest_DB e CalculadoraSalario, informando os dados de conexão com o msyql(banco, usuário, senha).



