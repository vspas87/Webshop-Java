package webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import webshop.entities.CategoryEntity;
import webshop.repositories.CategoryRepository;

@RestController
@RequestMapping(path="webshop/category")
public class CategoryController {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	//Lista svih kategorija
	@RequestMapping(method=RequestMethod.GET)
	public Iterable<CategoryEntity> getAllCCategories() {
		return categoryRepository.findAll();
	}

}
