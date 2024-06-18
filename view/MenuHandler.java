package view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MenuHandler {

    @FXML
    private TextField optionTextField;

    @FXML
    private void handleOptionSelection() {
        String option = optionTextField.getText();
        switch (option) {
            case "1":
                System.out.println("Iniciar Venda");
                break;
            case "2":
                System.out.println("Cadastrar Produto");
                break;
            case "3":
                System.out.println("Verificar estoque");
                break;
            case "4":
                System.out.println("Cadastrar Cliente");
                break;
            default:
                System.out.println("Opção inválida");
        }
        optionTextField.clear();
    }
}
