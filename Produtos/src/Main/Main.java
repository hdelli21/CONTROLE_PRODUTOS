
package Main;

import Produtos.ProdutoAlimenticio;
import Produtos.ProdutoVestuario;
import java.sql.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ProdutosDB";
        String user = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            ProdutoAlimenticio pa = new ProdutoAlimenticio("Biscoito", 1.50, 2.50, LocalDate.of(2024, 12, 31), "100kcal por porção");
            pa.salvar(conn);

            ProdutoVestuario pv = new ProdutoVestuario("Camisa", 15.00, 25.00, "M", "Azul", "Algodão");
            pv.salvar(conn);

            System.out.println("Produtos salvos com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
