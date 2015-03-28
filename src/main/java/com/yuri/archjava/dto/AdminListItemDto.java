package com.yuri.archjava.dto;

/**
 * Created by yuri on 22.03.2015.
 */
public class AdminListItemDto {
    private String email;
    private String balance;
    private String date;

    public AdminListItemDto(String email, String balance, String date) {
        this.email = email;
        this.balance = balance;
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
