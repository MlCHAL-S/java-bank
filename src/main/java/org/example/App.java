package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.Models.Model;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        Model.getInstance().getViewFactory().showLoginWindow();
        //7:04
    }
}