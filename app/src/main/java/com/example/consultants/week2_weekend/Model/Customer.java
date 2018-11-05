package com.example.consultants.week2_weekend.Model;

public class Customer {
    String Name;
    String Phone;
    String Age;

    @Override
    public String toString() {
        return "Customer{" +
                "Name='" + Name + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Age='" + Age + '\'' +
                '}';
    }

    //getter and setter
    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    //constructor
    public Customer(String name, String phone, String age) {
        Name = name;
        Phone = phone;
        Age = age;
    }

}
