package com.hp.sap.ecom;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private boolean blacklist;
    private List<Purchase> purchases;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPurchase(Purchase p) {
        if (purchases == null) {
            purchases = new ArrayList<>();
        }
        purchases.add(p);
    }

    public void removePurchase(Purchase p) {
        purchases.remove(p);
        if (purchases.size() == 0) {
            purchases = null;
        }
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public boolean isBlacklist() {
        return blacklist;
    }

    public void setBlacklist(boolean blacklist) {
        this.blacklist = blacklist;
        this.purchases = null;
    }

    public boolean hasAnyPurchase() {
        return purchases != null;
    }

}
