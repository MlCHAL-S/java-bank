package org.example.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import org.example.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

    public BorderPane client_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().addListener((observable, oldVal, newVal) -> {
            switch (newVal){
                case "Transactions" -> client_parent.setCenter(Model.getInstance().getViewFactory().getTransitionsView());
                case "Accounts" -> client_parent.setCenter(Model.getInstance().getViewFactory().getAccountsView());
                default -> client_parent.setCenter(Model.getInstance().getViewFactory().getDashBoardView());
            }
        });
    }
}
