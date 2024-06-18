package model.DAO;

import model.entidades.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO extends AbstractDAO<Produto> {

    public ProdutoDAO() {
        createTableIfNotExists();
    }

    private void createTableIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS produtos ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nome TEXT NOT NULL, "
                + "preco DECIMAL(10, 2) NOT NULL, "
                + "descricao TEXT NOT NULL, "
                + "estoque TEXT NOT NULL, "
                + "categoria INTEGER NOT NULL"
                + ");";

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            conn.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insert(Produto produto) {
        String sql = "INSERT INTO produtos(nome, preco, descricao, estoque, categoria) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, produto.getNome());
            pstmt.setBigDecimal(2, produto.getPreco());
            pstmt.setString(3, produto.getDesc());
            pstmt.setInt(4, produto.getEstoque());
            pstmt.setInt(5, produto.getCategoria());
            pstmt.executeUpdate();
            conn.commit();
            System.out.println("Produto inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Produto get(long id) {
        String sql = "SELECT id, nome, preco, descricao FROM produtos WHERE id = ?";
        Produto produto = new Produto();

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                produto.setId(rs.getLong("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getBigDecimal("preco"));
                produto.setDescricao(rs.getString("descricao"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return produto;
    }

    @Override
    public List<Produto> getAll() {
        String sql = "SELECT nome FROM produtos";
        List<Produto> produtos = new ArrayList<>();

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setNome(rs.getString("nome"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return produtos;
    }

    @Override
    public void update(Produto produto) {
        String sql = "UPDATE produtos SET nome = ?, preco = ?, descricao = ? WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, produto.getNome());
            pstmt.setBigDecimal(2, produto.getPreco());
            pstmt.setString(3, produto.getDesc());
            pstmt.setLong(4, produto.getCod());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM produtos WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
