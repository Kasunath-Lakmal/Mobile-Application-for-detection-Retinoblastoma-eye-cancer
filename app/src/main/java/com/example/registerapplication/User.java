package com.example.registerapplication;

public class User {

    String UserId;
    String FullName;
    String EmailAddress;
    String PhoneNumber;

    public User(String userId, String fullName, String emailAddress, String phoneNumber) {

        FullName = fullName;
        EmailAddress = emailAddress;
        PhoneNumber = phoneNumber;
    }

    public String getUserId() {
        return UserId;
    }

    public String getFullName() {
        return FullName;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }
}
