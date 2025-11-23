// package com.vti.entity;

public class Student{
    private int id;
    private String name;
    private String email;
    
    public Student(){

    }
    public Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "User [ID: " + this.id + ", Name: " + this.name + ", Email: " + this.email + "]";
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
}