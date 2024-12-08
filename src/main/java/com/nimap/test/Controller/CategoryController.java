package com.nimap.test.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.test.Entity.Category;
import com.nimap.test.Service.CategoryServiceInterface;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryServiceInterface categoryService;

	@PostMapping
	public Category addCategory(@RequestBody Category category) {
		return this.categoryService.addCategory(category);
	}

	@GetMapping
	public Page<Category> getAllCategories(Pageable pageable) {
		return categoryService.getAllCategories(pageable);
	}

	@GetMapping("/{categoryId}")
	public Category getAllCategory(@PathVariable int categoryId) {
		return categoryService.getCategoryByCategoryId(categoryId);
	}

	@DeleteMapping("{categoryId}")
	public void deleteCategory(@PathVariable int categoryId) {
		this.categoryService.deleteCategory(categoryId);
	}

	@PutMapping("{categoryId}")
	public void deleteCategory(@PathVariable int categoryId, @RequestBody Category category) {
		this.categoryService.modifyCategory(categoryId, category);
	}
}