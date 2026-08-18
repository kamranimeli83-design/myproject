package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

// <User, Integer> یعنی این ریپازیتوری برای کلاس User است و کلید اصلی آن از نوع Integer است
public interface UserRepository extends JpaRepository<User, Integer> {
    // ما هیچ متدی نمی‌نویسیم، زیرا CrudRepository متدهای save، findById، findAll، deleteById و ... را دارد.
}