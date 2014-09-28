package dbunit;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.DatabaseTestCase;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Test;

/**
 * A presente classe � respons�vel pelos teste da classe CalcularSalario
 */
public class CalculadoraSalarioTest_DB extends DatabaseTestCase {

	private FlatXmlDataSet loadedDataSet;
	private CalculadoraSalario calculadoraSalario;
	private Connection jdbcConnection;

	/**
	 * Fornecer uma conex�o com o banco de dados
	 * 
	 * @return IDatabaseConnection
	 */
	protected IDatabaseConnection getConnection() throws Exception {
		// carrega do drive mysql
		Class.forName("com.mysql.jdbc.Driver");

		// obtem a conex�o com o banco de dados
		jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost/dbunit_banco", "root", "");

		// retorna um objeto com a conex�o
		return new DatabaseConnection(jdbcConnection);

	}// fim getConnection()

	/**
	 * Carregar os dados que v�o ser inseridos para o teste
	 * 
	 * @return IDataSet
	 */
	protected IDataSet getDataSet() throws Exception {

		// obter o arquivo xml
		File arquivo = new File("dbunitData.xml");

		// carrega o xml
		loadedDataSet = new FlatXmlDataSet(arquivo);

		// retorna o arquivo carregado
		return loadedDataSet;

	}// fim getDataSet()

	/**
	 * Caso de teste para calcular sal�rio cen�rio positivo --- Empregado V�lido
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCalcular() throws Exception {
		System.out.println("executou testCalcular()");

		// obtem objeto CalculadoraSalario
		calculadoraSalario = new CalculadoraSalario();

		// obtem o valor do sal�rio calculado
		int salario = calculadoraSalario.calcular("24356A");

		// verifica se um valor<esperado> � igual ao outro<obtido>
		assertEquals(13245, salario);

	}// fim testCalcular()

	/**
	 * Executando antes de cada teste
	 * 
	 * @throws Exception
	 */
	protected DatabaseOperation getSetUpOperation() throws Exception {

		// Esta opera��o insere o conte�do do conjunto de dados no banco de
		// dados.
		return DatabaseOperation.INSERT;

	}// fim getSetUpOperation()

	/**
	 * Excutando no final de cada teste
	 * 
	 * @throws Exception
	 */
	protected DatabaseOperation getTearDownOperation() throws Exception {

		// Esta opera��o exclui apenas o conte�do do conjunto de dados do banco
		// de dados
		DatabaseOperation.DELETE.execute(getConnection(), getDataSet());

		// Opera��o vazia que n�o faz absolutamente nada.
		return DatabaseOperation.NONE;

	}// fim getTearDownOperation()

}// fim class CalculadoraSalarioTest_DB
