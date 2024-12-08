package com.nimap.test.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.test.Entity.Category;
import com.nimap.test.Repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryServiceInterface {

	@Autowired
	CategoryRepo categoryRepo;

	@Override
	public Category addCategory(Category category) {
		return categoryRepo.save(category);
	}

	public Page<Category> getAllCategories(Pageable pageable) {
		return categoryRepo.findAll(pageable);
	}

	@Override
	public Category getCategoryByCategoryId(int categoryId) {
		return categoryRepo.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
	}

	@Override
	public void deleteCategory(int categoryId) {
		categoryRepo.deleteById(categoryId);
	}

	@Override
	public Category modifyCategory(int id, Category categoryDetails) {
		Category category = getCategoryByCategoryId(id);
		category.setCategoryName(categoryDetails.getCategoryName());
		category.setCategoryDesc(categoryDetails.getCategoryDesc());
		return categoryRepo.save(category);
	}

}