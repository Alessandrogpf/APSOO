package model.entidades;

import java.math.BigDecimal;

public class Produto {

    private Long codProduto;

    private String nome;

    private BigDecimal preco;

    private String descricao;

    private int estoque;

    private Integer categoria;

    /***********
     * MÉTODOS *
     ***********/

    /**
     * GETTERS e SETTERS
     **/
    public Long getCod() {
        return this.codProduto;
    }

    public String getNome() {
        return this.nome;
    }

    public BigDecimal getPreco() {
        return this.preco;
    }

    public String getDesc() {
        return this.descricao;
    }

    public int getEstoque() {
        return this.estoque;
    }

    public Integer getCategoria() {
        return this.categoria;
    }

    public void setId(Long codProduto) {
        this.codProduto = codProduto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setEstoque(Integer qtdEstoque) {
        this.estoque = qtdEstoque;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    /**
     * FUNÇÕES
     **/
    public void decrementaEstoque(int quant) {
        if (quant > this.estoque) {
            // Possível exceção aqui
        }
        this.estoque = this.estoque - quant;
    }

}
