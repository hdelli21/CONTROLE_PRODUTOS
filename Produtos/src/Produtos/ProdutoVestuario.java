
package Produtos;

import java.sql.*;

public class ProdutoVestuario extends Produto {
    private String tamanho;
    private String cor;
    private String material;

    public ProdutoVestuario(String nome, double precoCusto, double precoVenda, String tamanho, String cor, String material) {
        super(nome, precoCusto, precoVenda);
        this.tamanho = tamanho;
        this.cor = cor;
        this.material = material;
    }

    @Override
    public void salvar(Connection conn) throws SQLException {
        super.salvar(conn);

        String sql = "INSERT INTO ProdutoVestuario (produto_id, tamanho, cor, material) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, tamanho);
            stmt.setString(3, cor);
            stmt.setString(4, material);
            stmt.executeUpdate();
        }
    }

    @Override
    public void atualizar(Connection conn) throws SQLException {
        super.atualizar(conn);

        String sql = "UPDATE ProdutoVestuario SET tamanho = ?, cor = ?, material = ? WHERE produto_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tamanho);
            stmt.setString(2, cor);
            stmt.setString(3, material);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(Connection conn) throws SQLException {
        String sql = "DELETE FROM ProdutoVestuario WHERE produto_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
        super.deletar(conn);
    }
}
