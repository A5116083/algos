package com.company.symboltable;

import java.util.Comparator;

public class Transaction implements Comparable<Transaction> {

    private String name;
    private String lastName;
    private double amount;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public double getAmount() {
        return amount;
    }

    public Transaction(String name, String lastName, double amount) {
        this.name = name;
        this.lastName = lastName;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (Double.compare(that.amount, amount) != 0) return false;
        if (!name.equals(that.name)) return false;
        return lastName.equals(that.lastName);
    }

    @Override
    public int hashCode() {
        int hash=1;
        hash = 31*hash + this.name.hashCode();
        hash= 31*hash + this.lastName.hashCode();
        hash = 31*hash + ((Double) this.amount).hashCode();
        return hash;
    }

    @Override
    public int compareTo(Transaction that) {
        return Double.compare(this.amount, that.amount);
    }

    private static class FirstNameComparator implements Comparator<Transaction>{

        @Override
        public int compare(Transaction left, Transaction right) {
            return  left.name.compareTo(right.name);
        }
    }
    private static class LastNameComparator implements Comparator<Transaction>{

        @Override
        public int compare(Transaction left, Transaction right) {
            return  left.lastName.compareTo(right.lastName);
        }
    }
    private static class AmountComparator implements Comparator<Transaction>{

        @Override
        public int compare(Transaction left, Transaction right) {
            return  Double.compare(left.amount, right.amount);
        }
    }

}
