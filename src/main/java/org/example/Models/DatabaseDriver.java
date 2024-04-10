package org.example.Models;

import java.sql.*;

public class DatabaseDriver {
    private Connection conn;

    public DatabaseDriver() {
        try {
            this.conn = DriverManager.getConnection("jdbc:sqlite:bank.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////    CLIENT SECTION    //////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////

    public ResultSet getClientData(String pAddress, String password) {
        Statement statement;
        ResultSet resultSet = null;

        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Clients WHERE PayeeAddress='"+pAddress+"' AND Password='"+password+"';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getChcekingAccountData(String pAddress) {
        Statement statement;
        ResultSet resultSet = null;

        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM CheckingAccounts WHERE Owner='"+pAddress+"';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getSavingsAccountData(String pAddress) {
        Statement statement;
        ResultSet resultSet = null;

        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM SavingsAccounts WHERE Owner='"+pAddress+"';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////    Admin SECTION    ///////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////    Utility SECTION    ///////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////
}
