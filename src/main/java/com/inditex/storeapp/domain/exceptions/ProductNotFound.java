package com.inditex.storeapp.domain.exceptions;

public class ProductNotFound extends RuntimeException{
    public ProductNotFound() {
        super("No prices found for the product");
    }
}
