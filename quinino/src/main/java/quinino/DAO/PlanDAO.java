/**
 * 
 */
package quinino.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlanDAO {

	private String url = "jdbc:mysql://localhost:3306/BD_QUININO";
	private String user = "root";
	private String password = "23201207";
	private Connection conexao = null;
	private ResultSet rst;

	public PlanDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConexao() {
		return conexao;
	}

	public float getTaxa(String codigoOrigem, String codigoDestino) throws SQLException {
		rst = conexao.createStatement().executeQuery("SELECT PRECO_MINUTO FROM tb_ddd " + "WHERE ORIGEM =  "
				+ codigoOrigem + " AND DESTINO = " + codigoDestino);
		
		System.out.println(rst.getStatement().toString());
		   
		if (rst.next())
			return rst.getFloat("PRECO_MINUTO");
		else
			return 00;

	}
}
