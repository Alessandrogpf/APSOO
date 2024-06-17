package controller;

import DAO.ProdutoDAO;
import model.entidades.Produto;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = buildProduto();

        produtoDAO.insert(produto);
        System.out.println("Produto inserido com sucesso!");
    }

    private static Produto buildProduto() {
        Produto produtoNovo = new Produto();

        produtoNovo.setNome("Produto Teste");
        produtoNovo.setPreco(new BigDecimal("29.99"));
        produtoNovo.setDescricao("Descrição teste");
        produtoNovo.setEstoque(150);
        produtoNovo.setCategoria(2);

        return produtoNovo;
    }
}
