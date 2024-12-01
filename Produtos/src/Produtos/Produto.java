
package Produtos;

import java.sql.*;

public class Produto {
    protected int id;
    protected String nome;
    protected double precoCusto;
    protected double precoVenda;

    public Produto(String nome, double precoCusto, double precoVenda) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
    }

    public double calcularLucro() {
        return precoVenda - precoCusto;
    }

    public void salvar(Connection conn) throws SQLException {
        String sql = "INSERT INTO Produto (nome, preco_custo, preco_venda) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, nome);
            stmt.setDouble(2, precoCusto);
            stmt.setDouble(3, precoVenda);
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id = generatedKeys.getInt(1);
                }
            }
        }
    }

    public void atualizar(Connection conn) throws SQLException {
        String sql = "UPDATE Produto SET nome = ?, preco_custo = ?, preco_venda = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setDouble(2, precoCusto);
            stmt.setDouble(3, precoVenda);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }

    public void deletar(Connection conn) throws SQLException {
        String sql = "DELETE FROM Produto WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
