package webshop.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import webshop.entities.UserEntity;
import webshop.repositories.UserRepository;

@RestController
@RequestMapping(value="webshop/user")
public class UserController<UserRole> {
	
	@Autowired
	UserRepository userRepository;
	
	
	//Lista svih usera
	@RequestMapping(method=RequestMethod.GET)
	public Iterable<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}
	
	//Lista usera po ID
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public UserEntity getUserById(@PathVariable Integer id) {
		return userRepository.findById(id).orElse(null);
	}
	
	//Dodavanje novog usera
	@RequestMapping(method=RequestMethod.POST)
	public UserEntity addNewUser(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String username,
			@RequestParam String password, @RequestParam String email) {
		UserEntity user= new UserEntity();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		userRepository.save(user);
		return user;
	}
	
	//Izmena postojeceg korisnika
	@RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
	public UserEntity updateUser(@PathVariable Integer id, @RequestParam String firstname, @RequestParam String lastname, 
			@RequestParam String username, @RequestParam String email) {
		UserEntity user= new UserEntity();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setUsername(username);
		user.setEmail(email);
		userRepository.save(user);
		return user;
	}
	
	/*Izmena atributa user_role postojećeg korisnika
	@RequestMapping(method=RequestMethod.PUT, value="/change/{id}/role/{role}")
	public UserEntity changeRole(@PathVariable Integer id, @PathVariable UserRole role) {
		UserEntity user= new UserEntity();
	
	}
*/
}
