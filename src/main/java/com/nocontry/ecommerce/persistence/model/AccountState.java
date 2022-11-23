package com.nocontry.ecommerce.persistence.model;



public enum AccountState {

    ACTIVE, INACTIVE, BLOCKED, DELETED;

    public String getAccountState() {
        return this.name();
    }
}
