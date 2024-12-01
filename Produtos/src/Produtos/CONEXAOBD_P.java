package Produtos;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class CONEXAOBD_P {
	private static final String URL = "jdbc:mysql://localhost:3306/ProdutosDB";
	private static final String USUARIO = "root";
	private static final String SENHA = "";

	public static Connection conectar () {
		Connection conexao = null;
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		conexao = DriverManager.getConnection(URL, USUARIO , SENHA);
		System.out.println ("Conexao realizada com sucesso!");
	}catch 	(ClassNotFoundException e ) {
		System.err.println ("Driver não encontrado: " + e.getMessage());
	} catch (SQLException e ) {
		System.err.println ("Erro ao conectar: " + e.getMessage());
	}
	return conexao;
	}
	public static void main (String[] args) {
		
		conectar ();
	}
	}
