package controller;

import model.business.ProdutoService;

public class ProdutosController {

    ProdutoService service = new ProdutoService();

    public void inserir() {
        service.inserir();
    }

    public void obterPorId() {
        service.obterPorId();
    }

    public void atualizar() {
        service.atualizar();
    }

    public void deletar() {
        service.deletar();
    }
}
