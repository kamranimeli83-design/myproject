package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity  // یعنی این کلاس به یک جدول در دیتابیس نگاشت می‌شود
public class User {

    @Id   // مشخص می‌کند که این فیلد کلید اصلی (Primary Key) است
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ← این خط را تغییر دهید
    private Integer id;

    private String name;
    private String email;

    // سازنده خالی (اجباری برای JPA)
    public User() {
    }

    // سازنده با پارامتر (برای راحتی کار)
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getter و Setter برای همه فیلدها
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}