package org.example.Controllers.Admin;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.example.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {
    public Button create_client_btn;
    public Button clients_btn;
    public Button deposit_btn;
    public Button logout_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void addListeners() {}

    private void onCreateClient() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set("CreateClient");
    }
}
