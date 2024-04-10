package org.example.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import org.example.Models.CheckingAccount;
import org.example.Models.Client;
import org.example.Models.Model;
import org.example.Models.SavingsAccount;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    public Text user_name_fld;
    public Label login_date;
    public Label checking_bal;
    public Label checking_acc_num;
    public Label savings_bal;
    public Label savings_acc_num;
    public Label income_lbl;
    public Label expense_lbl;
    public ListView transaction_listview;
    public TextField payee_fld;
    public TextField amount_fld;
    public TextArea message_fld;
    public Button send_money_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Client loggedInClient = Model.getInstance().getClient();
        CheckingAccount checkingAccount = (CheckingAccount) loggedInClient.cAccountProperty().getValue();
        SavingsAccount savingsAccount = (SavingsAccount) loggedInClient.sAccountProperty().getValue();

        user_name_fld.setText("Hi, "+loggedInClient.firstNameProperty().getValue());
        login_date.setText(getLoginDate());
        checking_bal.setText("$ "+checkingAccount.balanceProperty().getValue());
        checking_acc_num.setText(checkingAccount.accountNumberProperty().getValue());
        savings_bal.setText("$ "+savingsAccount.balanceProperty().getValue());
        savings_acc_num.setText(savingsAccount.accountNumberProperty().getValue());
    }

    private static String getLoginDate() {
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, yyyy-MM-dd", Locale.ENGLISH);

        return now.format(formatter);
    }
}
