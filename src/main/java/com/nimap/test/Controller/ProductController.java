package com.nimap.test.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.test.Entity.Product;
import com.nimap.test.Service.ProductServiceInterface;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductServiceInterface productService;

	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return this.productService.addProduct(product);
	}

	@GetMapping
	public Page<Product> getAllProducts(Pageable pageable) {
		return productService.getAllProducts(pageable);
	}

	@GetMapping("/{productId}")
	public Product getProductByProductId(@PathVariable int productId) {

		return this.productService.getProductByProductId(productId);
	}

	@DeleteMapping("/{productId}")
	public void deleteProduct(@PathVariable int productId) {
		this.productService.deleteProduct(productId);
	}
}