package org.sid.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.sid.dao.PictureRepository;
import org.sid.entities.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PictureRestService {
	@Autowired
	private PictureRepository pictureRepository;
	
	//Afficher tous les photos
	@Secured(value={"ROLE_ADMIN", "ROLE_USER"})
	@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
	@RequestMapping(value="/pictures", method=RequestMethod.GET)
	public List<Picture> getPictures(){
		return pictureRepository.findAll();
	} 
	//Afficher une photo par ID
	@Secured(value={"ROLE_ADMIN", "ROLE_USER"})
	@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
	@RequestMapping(value="/pictures/{id}", method=RequestMethod.GET)
	public Optional<Picture> getPicture(@PathVariable Long id){
		return pictureRepository.findById(id);
		}
//Autres methode Post coté navigateur
	
	@Secured(value={"ROLE_ADMIN", "ROLE_USER"})
@RequestMapping(value="/savePicture", method=RequestMethod.GET)
	public Picture savePicture(Picture p) {
		return pictureRepository.save(p);
	}

	
	//Pour enregister un photo
	@Secured(value={"ROLE_ADMIN", "ROLE_USER"})
	@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
	@RequestMapping(value="/pictures", method=RequestMethod.POST)
	public Picture addPicture(@RequestBody Picture p){
		return pictureRepository.save(p);
		}
	//Pour mettre à jour un utilisateur
	@Secured(value={"ROLE_ADMIN", "ROLE_USER"})
	@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
	@RequestMapping(value="/pictures/{id}", method=RequestMethod.PUT)
	public Picture updateUser(@PathVariable Long id, @RequestBody Picture p){
			p.setId(id);
			return pictureRepository.save(p);
					}
	//Pour supprimer un photo
			@Secured(value={"ROLE_ADMIN", "ROLE_USER"})
			@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
			@RequestMapping(value="/pictures/{id}", method=RequestMethod.DELETE)
			public boolean deletePicture(@PathVariable Long id){
				pictureRepository.deleteById(id);
				return true;
			}
			//Recherche un photo par mot clé
			
			@SuppressWarnings("deprecation")
			@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
			@RequestMapping(value="/rechercherPictures", method=RequestMethod.GET)
			public Page<Picture> rechercher(
					@RequestParam(name="mc", defaultValue="") String mc,
					@RequestParam(name="page", defaultValue="0") int page,
					@RequestParam(name="size", defaultValue="10") int size){	
				return pictureRepository.rechercher("%"+mc+"%", new PageRequest(page, size));
			}
			@RequestMapping(value="/getLogedUser")
			public Map<String, Object> getLogedUser(HttpServletRequest httpServletRequest){
				HttpSession httpSession=httpServletRequest.getSession();
				SecurityContext securityContext= (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
				String login= securityContext.getAuthentication().getName();
				List<String> roles= new ArrayList<>();
				for(GrantedAuthority ga:securityContext.getAuthentication().getAuthorities()) {
					roles.add(ga.getAuthority());
					
				}
				Map<String,Object >params=new HashMap<>();
				params.put("login", login);
				params.put("roles", roles);
				return params;
			}
			
}


