package webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import webshop.entities.UserRole;
import webshop.repositories.UserRoleRepository;

@RestController
@RequestMapping(path="webshop/role")
public class UserRoleController {
	
	@Autowired
	UserRoleRepository userRole;
	
	//Dodaj nove role
	@RequestMapping(method=RequestMethod.POST, value="/add")
	public UserRole addNewRole(@RequestParam String roleName) {
		UserRole role= new UserRole();
		role.setRoleName(roleName);
		userRole.save(role);
		return role;
	}

}  
