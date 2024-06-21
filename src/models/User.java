package models;

import java.util.UUID;
import java.util.function.DoubleToIntFunction;

public class User {
    private String userId;
    private String phoneNo;
    private String password;
    private String name;
    private String email;
    private Double balance;

    public User(String phoneNo, String password) {
        this.userId = UUID.randomUUID().toString();
        this.phoneNo = phoneNo;
        this.password = password;
        this.balance = 0.0;
    }

    public User(String userId, String phoneNo, String password, String name, String email, Double balance) {
        this.userId = userId;
        this.phoneNo = phoneNo;
        this.password = password;
        this.name = name;
        this.email = email;
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void displayDetails() {
        System.out.println("User Det");
        System.out.println("user = { userId: " + userId +
                            ", phoneNo: " + phoneNo +
                            ", password: XXXXXXXXXX" +
                            ", name: " + name +
                            ", emailId: " + email +
                            ", balance: " + balance + " }"
                );

    }

}
