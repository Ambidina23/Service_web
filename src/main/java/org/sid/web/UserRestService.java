package org.sid.web;
import java.util.List;
import java.util.Optional;

import org.sid.dao.UserRepository;
import org.sid.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestService {
	@Autowired
	private UserRepository userRepository;
	
	//Afficher tous les utilisateurs
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<User> getUsers(){
		return userRepository.findAll();
	} 
	//Afficher un utilisateur par ID
	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	public Optional<User> getUser(@PathVariable Long id){
		return userRepository.findById(id);
	}
	//Recherche un utilisateur par mot clé
		@SuppressWarnings("deprecation")
		@RequestMapping(value="/chercherUser", method=RequestMethod.GET)
		public Page<User> chercher(
				@RequestParam(name="mc", defaultValue="") String mc,
				@RequestParam(name="page", defaultValue="0") int page,
				@RequestParam(name="size", defaultValue="5") int size){	
			return userRepository.chercher("%"+mc+"%", new PageRequest(page, size));
		}
	//Pour enregister un utilisateur
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public User addUser(@RequestBody User u){
		return userRepository.save(u);
	}
	//Pour supprimerr un utilisateur
		@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
		public boolean deleteUser(@PathVariable Long id){
			userRepository.deleteById(id);
			return true;
		}
	//Pour mettre à jour un utilisateur
		@RequestMapping(value="/users/{id}", method=RequestMethod.PUT)
		public User updateUser(@PathVariable Long id, @RequestBody User u){
			u.setId(id);
			return userRepository.save(u);
				}
}

