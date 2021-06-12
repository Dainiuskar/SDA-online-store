package com.example.onlinestore.model.entity;

public enum Role {
    ADMIN, USER;

    @Override
    public String toString() {
        return "ROLE_" + this.name();
    }
}
