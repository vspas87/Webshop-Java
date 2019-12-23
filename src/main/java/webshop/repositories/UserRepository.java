package webshop.repositories;

import org.springframework.data.repository.CrudRepository;

import webshop.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
	
	

}
