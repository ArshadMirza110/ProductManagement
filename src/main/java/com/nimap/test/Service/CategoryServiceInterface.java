package com.nimap.test.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nimap.test.Entity.Category;

public interface CategoryServiceInterface {

	public Category addCategory(Category category);

	public Page<Category> getAllCategories(Pageable pageable);

	public Category getCategoryByCategoryId(int categoryId);

	void deleteCategory(int categoryId);

	Category modifyCategory(int categoryId, Category category);
}