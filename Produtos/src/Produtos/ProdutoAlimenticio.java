
package Produtos;

import java.sql.*;
import java.time.LocalDate;

public class ProdutoAlimenticio extends Produto {
    private LocalDate dataValidade;
    private String infoNutricionais;

    public ProdutoAlimenticio(String nome, double precoCusto, double precoVenda, LocalDate dataValidade, String infoNutricionais) {
        super(nome, precoCusto, precoVenda);
        this.dataValidade = dataValidade;
        this.infoNutricionais = infoNutricionais;
    }

    @Override
    public void salvar(Connection conn) throws SQLException {
        super.salvar(conn);

        String sql = "INSERT INTO ProdutoAlimenticio (produto_id, data_validade, info_nutricionais) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setDate(2, Date.valueOf(dataValidade));
            stmt.setString(3, infoNutricionais);
            stmt.executeUpdate();
        }
    }

    @Override
    public void atualizar(Connection conn) throws SQLException {
        super.atualizar(conn);

        String sql = "UPDATE ProdutoAlimenticio SET data_validade = ?, info_nutricionais = ? WHERE produto_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(dataValidade));
            stmt.setString(2, infoNutricionais);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(Connection conn) throws SQLException {
        String sql = "DELETE FROM ProdutoAlimenticio WHERE produto_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
        super.deletar(conn);
    }
}
