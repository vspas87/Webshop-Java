package webshop.repositories;

import org.springframework.data.repository.CrudRepository;

import webshop.entities.CategoryEntity;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {

}
