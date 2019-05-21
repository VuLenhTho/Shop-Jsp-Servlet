package model;

import java.sql.Timestamp;

public class AccountModel {
    private Long id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private Timestamp createdDate;
    private String email;
    private String phoneNumber;
    private Integer sexID;
    private Integer roleID;

    public AccountModel() {
    }

    public AccountModel(long id, String userName, String password, String firstName, String lastName, Timestamp createdDate, String email, String phoneNumber, int sexID, int roleID) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdDate = createdDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.sexID = sexID;
        this.roleID = roleID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getSexID() {
        return sexID;
    }

    public void setSexID(Integer sexID) {
        this.sexID = sexID;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }
}
