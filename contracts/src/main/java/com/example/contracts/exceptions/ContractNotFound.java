package com.example.contracts.exceptions;

public class ContractNotFound extends Exception {
    public ContractNotFound(String contractNotFound) {
        super(contractNotFound);
    }
}
