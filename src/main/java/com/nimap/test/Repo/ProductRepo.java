package com.nimap.test.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nimap.test.Entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}