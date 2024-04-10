package org.example.Models;

import org.example.Views.AccountType;
import org.example.Views.ViewFactory;

import java.sql.ResultSet;
import java.time.LocalDate;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;
    private AccountType loginAccountType = AccountType.CLIENT;

    // Client Data Section
    private final Client client;
    private boolean clientLoginSuccessFlag;

    // Admin Data Section

    private Model(){
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();

        this.clientLoginSuccessFlag = false;
        this.client = new Client("", "", "", null, null, null);
    }

    public static synchronized Model getInstance(){
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory(){
        return viewFactory;
    }

    public DatabaseDriver getDatabaseDriver() { return databaseDriver; }

    public AccountType getLoginAccountType() { return loginAccountType; }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////    CLIENT SECTION    //////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////
    public boolean getClientLoginSuccessFlag() { return this.clientLoginSuccessFlag; }
    public void setClientLoginSuccessFlag(boolean flag) { this.clientLoginSuccessFlag = flag; }

    public Client getClient() {
        return client;
    }

    public void evaluateClientCred(String pAddress, String password) {
        CheckingAccount checkingAccount = new CheckingAccount("", "", 1, 1);
        SavingsAccount savingsAccount = new SavingsAccount("", "", 1, 1);

        ResultSet resultSet = databaseDriver.getClientData(pAddress, password);

        try {
            if (resultSet.isBeforeFirst()) {
                this.client.firstNameProperty().set(resultSet.getString("FirstName"));
                this.client.lastNameProperty().set(resultSet.getString("LastName"));
                this.client.pAddressProperty().set(resultSet.getString("PayeeAddress"));
                String[] dateParts = resultSet.getString("Date").split("-");
                LocalDate date =  LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
                this.client.dateProperty().set(date);

                resultSet = databaseDriver.getChcekingAccountData(this.client.pAddressProperty().getValue());
                checkingAccount.balanceProperty().set(resultSet.getDouble("Balance"));
                checkingAccount.transactionLimitProperty().set(resultSet.getDouble("TransactionLimit"));
                checkingAccount.accountNumberProperty().set(resultSet.getString("AccountNumber"));
                checkingAccount.ownerProperty().set(resultSet.getString("Owner"));
                this.client.cAccountProperty().set(checkingAccount);
                System.out.println(this.client.cAccountProperty());

                resultSet = databaseDriver.getSavingsAccountData(this.client.pAddressProperty().getValue());
                savingsAccount.balanceProperty().set(resultSet.getDouble("Balance"));
                savingsAccount.withdrawLimitProperty().set(resultSet.getDouble("WithdrawalLimit"));
                savingsAccount.accountNumberProperty().set(resultSet.getString("AccountNumber"));
                savingsAccount.ownerProperty().set(resultSet.getString("Owner"));
                this.client.sAccountProperty().set(savingsAccount);

                this.clientLoginSuccessFlag = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
