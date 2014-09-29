DBUnit com Maven e Eclipse
====================

Exemplo simples de como utilizar o DBUnit com maven e eclipse, exemplificado com um teste simples.

O teste proposto mostra o poder do DBUnit onde ele proporciona um maior conforto na hora de testar registros no banco de dados, neste exemplo o banco de dados contém somente 1 registro em produção, quando o teste é executado o DBUnit carrega os dados em XML(dbunitData.xml) para o banco de dados os dados necessário para que o teste acorra, que neste momento contém 2 registros, depois de testado com os dados carregados, ao final do teste os dados são apagados automaticamente do banco voltando agora com 1 registro em produção, então veja a facilidade do DBUnit, eliminando a contaminação de registros de teste e o esforço do programador de excluir e inserir dados, mantendo assim o estado atual do banco de dados, e automatizando os testes.

Requisitos

- 1 - Ter importado este projeto para o eclipse
- 2 - Maven configurado no eclipse (update project..)
- 3 - Ter criado um banco de dados chamado "dbunit_banco" ou outro qualquer.
- 4 - Ter importado o arquivo "dbunit_banco.sql" que está na raiz deste projeto para o banco de dados informado.
- 5 - Ter configurado o metodo getConnection() da classe CalculadoraSalarioTest_DB e CalculadoraSalario, informando os dados de conexão com o mysql(banco, usuário, senha).

Feito isso, RUN TEST!!


