package dbunit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A presente classe é responsável por calcular salário
 */
public class CalculadoraSalario {

	/**
	 * Criando Conexão
	 * 
	 * @return Connection
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException {

		// retorna a conexão com o banco de dados
		return DriverManager.getConnection("jdbc:mysql://localhost/dbunit_banco", "root", "");

	}// fim getConnection()

	/**
	 * Calcula salário
	 * 
	 * @param EmpID
	 *            string
	 * @return salário
	 * @throws SQLException
	 */
	public int calcular(String EmpID) throws SQLException {

		Statement stmt = getConnection().createStatement();

		ResultSet rs = stmt.executeQuery("select * from detalhesSalario where EmpID='" + EmpID + "'");
		int salario = 0;
		int bonus = 0;
		int incremento = 0;

		while (rs.next()) {
			salario = rs.getInt("Salario");
			bonus = rs.getInt("Bonus");
			incremento = rs.getInt("Incremento");
		}// fim while

		// retorna valor do salário calculado
		return (salario + bonus + incremento);

	}// fim calcular()

}// fim class CalculadoraSalario