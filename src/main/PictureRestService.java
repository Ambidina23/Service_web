package org.sid.web;
import java.util.List;
import java.util.Optional;

import org.sid.dao.PictureRepository;
import org.sid.entities.Picture;
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
public class PictureRestService {
	@Autowired
	private PictureRepository pictureRepository;
	
	//Afficher tous les utilisateurs
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<Picture> getPictures(){
		return pictureRepository.findAll();
	} 
	//Afficher un utilisateur par ID
	@RequestMapping(value="/pictures/{id}", method=RequestMethod.GET)
	public Optional<Picture> getPicture(@PathVariable Long id){
		return pictureRepository.findById(id);
	}
	//Recherche un utilisateur par mot clé
		@SuppressWarnings("deprecation")
		@RequestMapping(value="/chercherPicture", method=RequestMethod.GET)
		public Page<Picture> chercher(
				@RequestParam(name="mc", defaultValue="") String mc,
				@RequestParam(name="page", defaultValue="0") int page,
				@RequestParam(name="size", defaultValue="5") int size){	
			return pictureRepository.chercher("%"+mc+"%", new PageRequest(page, size));
		}
	//Pour enregister un utilisateur
	@RequestMapping(value="/picture", method=RequestMethod.POST)
	public Picture addPicture(@RequestBody Picture p){
		return pictureRepository.save(p);
	}
	//Pour supprimerr un utilisateur
		@RequestMapping(value="/pictures/{id}", method=RequestMethod.DELETE)
		public boolean deletePicture(@PathVariable Long id){
			pictureRepository.deleteById(id);
			return true;
		}
	//Pour mettre à jour un utilisateur
		@RequestMapping(value="/users/{id}", method=RequestMethod.PUT)
		public Picture updateUser(@PathVariable Long id, @RequestBody Picture p){
			p.setId(id);
			return pictureRepository.save(p);
				}
}

