package org.sid.web;

import java.util.List;
import java.util.Optional;

import org.sid.dao.RoleRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.Picture;
import org.sid.entities.Role;
import org.sid.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Secured(value=("ROLE_ADMIN"))
public class UserRestService  {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	

	@RequestMapping(value="/users") 
	public List<User> findAll(){	
		return userRepository.findAll();	
	}
	//Pour enregister un utilisateur
		@Secured(value={"ROLE_ADMIN"})
		@RequestMapping(value="/user", method=RequestMethod.POST)
		public User addPicture(@RequestBody User u){
			return userRepository.save(u);
			}
		
	//Afficher un utilisateur par ID
		@Secured(value={"ROLE_ADMIN"})
		@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
		public Optional<User> getUser(@PathVariable String id){
			return userRepository.findById(id);
					}
		//Pour supprimer un utilisateur
		@Secured(value={"ROLE_ADMIN"})
		@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
		public boolean deleteUser(@PathVariable String id){
			userRepository.deleteById(id);
			return true;
		}
		//Pour mettre à jour un utilisateur
		@Secured(value={"ROLE_ADMIN"})
		@RequestMapping(value="/users/{id}", method=RequestMethod.PUT)
		public User updateUser(@PathVariable String id, @RequestBody User u){
				u.setLogin(id);
				return userRepository.save(u);
						}
	@RequestMapping(value="/addRole")
	public Role saveRole(Role r) {
		return roleRepository.save(r);	
	}
	@RequestMapping(value="/findRoles") 
	public List<User> findRoles(){	
		return userRepository.findAll();	
	}
	/*@RequestMapping(value="/addRoleToUser")
	public User addRoleToUser(String login, String role) {
		User u=userRepository.findOne(login);
		Role r=roleRepository.findOne(role);
		u.getRoles().add(r);
		userRepository.save(u);
		return u;*/

	}
		
	


