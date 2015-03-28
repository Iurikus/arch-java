package com.yuri.archjava.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Created by yuri on 19.03.2015.
 */

@Entity

@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Length(min = 5, max = 10)
    private String password;

    @Transient
    private String password2;

    @NotNull
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime registrationDate;

    @OneToMany( mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AccoutItem> accounts = new ArrayList<AccoutItem>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (accounts != null ? !accounts.equals(user.accounts) : user.accounts != null) return false;
        if (!email.equals(user.email)) return false;
        if (!password.equals(user.password)) return false;
        if (password2 != null ? !password2.equals(user.password2) : user.password2 != null) return false;
        if (!registrationDate.equals(user.registrationDate)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (password2 != null ? password2.hashCode() : 0);
        result = 31 * result + registrationDate.hashCode();
        result = 31 * result + (accounts != null ? accounts.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", password2='" + password2 + '\'' +
                ", registrationDate=" + registrationDate +
                ", accounts=" + Arrays.toString(accounts.toArray()) +
                '}';
    }

    public List<AccoutItem> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccoutItem> accounts) {
        this.accounts = accounts;
    }
}