package model.business;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.DAO.ProdutoDAO;
import model.entidades.Produto;

import java.math.BigDecimal;

public class ProdutoService {

    ProdutoDAO produtoDAO = new ProdutoDAO();

    public void abrirFormularioCadastroProduto() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Cadastro de Produto");
        dialog.setHeaderText("Preencha as informações do novo produto");

        ButtonType btnConfirmar = new ButtonType("Confirmar", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(btnConfirmar, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        TextField nomeField = new TextField();
        nomeField.setPromptText("Nome");

        TextField precoField = new TextField();
        precoField.setPromptText("Preço");

        TextField descricaoField = new TextField();
        descricaoField.setPromptText("Descrição");

        TextField estoqueField = new TextField();
        estoqueField.setPromptText("Estoque");

        grid.add(new Label("Nome:"), 0, 0);
        grid.add(nomeField, 1, 0);
        grid.add(new Label("Preço:"), 0, 1);
        grid.add(precoField, 1, 1);
        grid.add(new Label("Descrição:"), 0, 2);
        grid.add(descricaoField, 1, 2);
        grid.add(new Label("Estoque:"), 0, 3);
        grid.add(estoqueField, 1, 3);

        dialog.getDialogPane().setContent(grid);

        Button okButton = (Button) dialog.getDialogPane().lookupButton(btnConfirmar);
        okButton.setDisable(true);

        nomeField.textProperty().addListener((observable, oldValue, newValue) -> {
            okButton.setDisable(newValue.trim().isEmpty() || precoField.getText().isEmpty() || descricaoField.getText().isEmpty() || estoqueField.getText().isEmpty());
        });

        precoField.textProperty().addListener((observable, oldValue, newValue) -> {
            okButton.setDisable(newValue.trim().isEmpty() || nomeField.getText().isEmpty() || descricaoField.getText().isEmpty() || estoqueField.getText().isEmpty());
        });

        descricaoField.textProperty().addListener((observable, oldValue, newValue) -> {
            okButton.setDisable(newValue.trim().isEmpty() || nomeField.getText().isEmpty() || precoField.getText().isEmpty() || estoqueField.getText().isEmpty());
        });

        estoqueField.textProperty().addListener((observable, oldValue, newValue) -> {
            okButton.setDisable(newValue.trim().isEmpty() || nomeField.getText().isEmpty() || precoField.getText().isEmpty() || descricaoField.getText().isEmpty());
        });

        dialog.setResultConverter(button -> {
            if (button == btnConfirmar) {
                String nome = nomeField.getText();
                BigDecimal preco = new BigDecimal(precoField.getText());
                String descricao = descricaoField.getText();
                Integer estoque = Integer.valueOf(estoqueField.getText());

                Produto produto = new Produto(nome, preco, descricao, estoque, 1);

                produtoDAO.insert(produto);
            }
            return null;
        });

        dialog.showAndWait();
    }

    public void obterPorId() {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Buscar por ID");
        dialog.setHeaderText("Digite o ID do produto desejado:");

        ButtonType btnConfirmar = new ButtonType("Confirmar", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(btnConfirmar, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        TextField idField = new TextField();
        idField.setPromptText("ID");

        grid.add(new Label("ID:"), 0, 0);
        grid.add(idField, 1, 0);

        dialog.getDialogPane().setContent(grid);

        Button okButton = (Button) dialog.getDialogPane().lookupButton(btnConfirmar);
        okButton.setDisable(true);

        idField.textProperty().addListener((observable, oldValue, newValue) -> {
            okButton.setDisable(newValue.trim().isEmpty() || !newValue.matches("\\d+"));
        });

        dialog.setResultConverter(button -> {
            if (button == btnConfirmar) {
                long id = Long.parseLong(idField.getText());
                Produto produto = produtoDAO.get(id);

                if (produto == null) {
                    System.out.println("Produto não encontrado na base de dados");
                } else {
                    exibirModalProdutoEncontrado(produto);
                }
            }
            return null;
        });

        dialog.showAndWait();
    }

    private void exibirModalProdutoEncontrado(Produto produto) {
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("Detalhes do Produto");
        dialog.setHeaderText("Detalhes do Produto:");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("ID:"), 0, 0);
        grid.add(new Label(Long.toString(produto.getCod())), 1, 0);
        grid.add(new Label("Nome:"), 0, 1);
        grid.add(new Label(produto.getNome()), 1, 1);
        grid.add(new Label("Preço:"), 0, 2);
        grid.add(new Label(produto.getPreco().toString()), 1, 2);

        dialog.getDialogPane().setContent(grid);

        ButtonType btnFechar = new ButtonType("Fechar", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().add(btnFechar);

        dialog.showAndWait();
    }
}
