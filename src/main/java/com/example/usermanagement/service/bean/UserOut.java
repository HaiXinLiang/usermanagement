package com.example.usermanagement.service.bean;

public class UserOut {

    private String password; //from request
    private String firstName; //from request
    private String lastName; //from request
    private String email; //from request
    private String contactNumber; //from request
    private int age;
    private String gender;
    private String nationality;
    private String[] tags;

    public UserOut(String password,
                   String firstName,
                   String lastName,
                   String email,
                   String contactNumber,
                   int age,
                   String gender,
                   String nationality,
                   String tags
    ) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.age = age;
        this.gender = gender;
        this.nationality = nationality;
        this.tags = tags.split(":");
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

}
