package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")  // همه مسیرهای این کنترلر با /api/users شروع می‌شوند
public class UserController {

    @Autowired  // به‌طور خودکار UserRepository را تزریق می‌کند
    private UserRepository userRepository;

    // ایجاد یک کاربر جدید با پارامترهای name و email
    @GetMapping("/add")
    public String addUser(@RequestParam String name, @RequestParam String email) {
        User user = new User(name, email);
        userRepository.save(user);   // ذخیره در دیتابیس
        return "User saved with id: " + user.getId();
    }

    // دریافت لیست همه کاربران
    @GetMapping("/all")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    // دریافت یک کاربر بر اساس id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
}
