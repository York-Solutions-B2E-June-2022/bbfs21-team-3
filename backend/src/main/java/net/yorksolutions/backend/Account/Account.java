package net.yorksolutions.backend.Account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String username;
    String password;
    String role;

    public Account() {}

    public Account(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;

    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
}
