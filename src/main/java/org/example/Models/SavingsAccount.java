package org.example.Models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;


public class SavingsAccount extends Account{
    // the withdraw limit from the savings
    private final DoubleProperty withdrawLimit;

    public SavingsAccount(String owner, String accountNumber, double balance, double withdrawLimit) {
        super(owner, accountNumber, balance);
        this.withdrawLimit = new SimpleDoubleProperty(this, "Withdrawal Limit", withdrawLimit);
    }

    public DoubleProperty withdrawLimitProperty() {
        return this.withdrawLimit;
    }
}
