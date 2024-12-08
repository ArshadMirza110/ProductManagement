package com.nimap.test.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.test.Entity.Category;
import com.nimap.test.Entity.Product;
import com.nimap.test.Repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductServiceInterface {

	@Autowired
	ProductRepo productRepo;

	@Autowired
	private CategoryServiceInterface categoryService;

	@Override
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}

	public Page<Product> getAllProducts(Pageable pageable) {
		return productRepo.findAll(pageable);
	}

	@Override
	public Product getProductByProductId(int productId) {
		return productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
	}

	@Override
	public void deleteProduct(int productId) {
		productRepo.deleteById(productId);
	}

	@Override
	public void modifyProduct(int productId, Product productDetails) {
		Product product = getProductByProductId(productId);
		Category category = categoryService.getCategoryByCategoryId(productDetails.getCategory().getCategoryId());
		product.setProductName(productDetails.getProductName());
		product.setProductPrice(productDetails.getProductPrice());
		product.setProductQuantity(productDetails.getProductQuantity());
		product.setCategory(category);
		productRepo.save(product);
	}

}