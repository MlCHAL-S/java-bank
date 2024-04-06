module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens org.example to javafx.fxml;
    exports org.example;
    exports org.example.Controllers;
    exports org.example.Controllers.Admin;
    exports org.example.Controllers.Client;
    exports org.example.Models;
    exports org.example.Views;
}
