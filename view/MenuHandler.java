package view;

import controller.ProdutosController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MenuHandler {

    @FXML
    private TextField optionTextField;

    @FXML
    private void handleOptionSelection() {
        String option = optionTextField.getText();
        ProdutosController controller = new ProdutosController();
        switch (option) {
            case "1":
                System.out.println("Iniciar Venda");
                break;
            case "2":
                controller.inserir();
                break;
            case "3":
                System.out.println("Verificar estoque");
                break;
            case "4":
                System.out.println("Cadastrar Cliente");
                break;

            // Essas funcionalidades não serão implementadas na modal, estão aqui apenas para fins de teste
            case "5":
                controller.obterPorId();
                break;
            case "6":
                controller.atualizar();
                break;
            case "7":
                controller.deletar();
                break;
            case "8":
                controller.obterTodos();
                break;

            default:
                System.out.println("Opção inválida");
        }
        optionTextField.clear();
    }
}
