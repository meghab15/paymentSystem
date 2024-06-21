package models;

public class Account {

    private String id;
    private String accountNumber;
    private String ifscCode;
    private String name;

    public Account(String id, String accountNumber, String ifscCode, String name) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public String getName() {
        return name;
    }



}
