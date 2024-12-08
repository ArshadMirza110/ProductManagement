package com.nimap.test.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nimap.test.Entity.Category;

@Repository

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
