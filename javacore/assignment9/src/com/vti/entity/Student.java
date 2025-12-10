package com.vti.entity;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;


public class Student {
    private static AtomicInteger counter = new AtomicInteger(0);
    private int id;
    private String name;

    public Student(String name) {
        this.id = counter.incrementAndGet();
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student {id=" + id + ", name='" + name + "'}";
    }

   
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name); 
    }

    @Override
    public int hashCode() {
        return Objects.hash(name); 
    }
}