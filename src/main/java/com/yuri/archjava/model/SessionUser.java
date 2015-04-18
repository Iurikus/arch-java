package com.yuri.archjava.model;

/**
 * Created by yuri on 19.04.2015.
 */
public class SessionUser {
    private long id;
    private boolean admin;

    public SessionUser(long id, boolean admin) {
        this.id = id;
        this.admin = admin;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "SessionUser{" +
                "id=" + id +
                ", admin=" + admin +
                '}';
    }
}
