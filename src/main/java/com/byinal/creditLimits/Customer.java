package com.byinal.creditLimits;

public class Customer {

    private String name;
    private String address;
    private String postcode;
    private String phoneNumber;
    private Double creditLimit;
    private String birthday;

    public Customer(String name, String address, String postcode, String phoneNumber, Double creditLimit, String birthday) {
        this.name = name;
        this.address = address;
        this.postcode = postcode;
        this.phoneNumber = phoneNumber;
        this.creditLimit = creditLimit;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Customer{");
        sb.append("name='").append(name).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", postcode='").append(postcode).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", creditLimit=").append(creditLimit);
        sb.append(", birthday='").append(birthday).append('\'');
        sb.append('}');
        return sb.toString();
    }
}


class CustomerBuilder {

    private String name;
    private String address;
    private String postcode;
    private String phoneNumber;
    private Double creditLimit;
    private String birthday;


    public CustomerBuilder name(String name){
        this.name = name;
        return this;
    }

    public CustomerBuilder address(String address){
        this.address = address;
        return this;
    }

    public CustomerBuilder postcode(String postcode){
        this.postcode = postcode;
        return this;
    }

    public CustomerBuilder phoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }

    public CustomerBuilder creditLimit(Double creditLimit){
        this.creditLimit = creditLimit;
        return this;
    }

    public CustomerBuilder birthday(String birthday){
        this.birthday = birthday;
        return this;
    }

    public Customer build(){
        return new Customer(this.name, this.address, this.postcode, this.phoneNumber, this.creditLimit, this.birthday);
    }



}
