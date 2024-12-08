package com.nimap.test.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nimap.test.Entity.Product;

public interface ProductServiceInterface {

	public Product addProduct(Product product);

	public Page<Product> getAllProducts(Pageable pageable);

	public Product getProductByProductId(int productId);

	void deleteProduct(int productId);

	public void modifyProduct(int productId, Product product);
}