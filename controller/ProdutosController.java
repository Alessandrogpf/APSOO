package controller;

import model.business.ProdutoService;

public class ProdutosController {

    ProdutoService service = new ProdutoService();

    public void inserir() {
        service.abrirFormularioCadastroProduto();
    }

    public void obterPorId() {
        service.obterPorId();
    }
}
