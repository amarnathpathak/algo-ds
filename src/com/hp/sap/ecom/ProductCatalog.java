package com.hp.sap.ecom;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
    private static final Map<String, Integer> catalog = new HashMap<>(10);
            
    public static void addProduct(String product, int quantity){
        Integer qty = catalog.get(product)!=null ? catalog.get(product) : 0;
        catalog.put(product, quantity+qty);
    }
    public static void addProduct(String product){
        addProduct(product, 1);
    }
    public static void removeProduct(String product, int quantity){
        Integer qty = catalog.get(product);
        if(qty!=null && (qty -quantity )> 0)
            catalog.put(product, qty-quantity);
        else
            catalog.remove(product);
    }

}
