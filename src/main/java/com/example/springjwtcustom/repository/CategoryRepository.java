package com.example.springjwtcustom.repository;

import com.example.springjwtcustom.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
