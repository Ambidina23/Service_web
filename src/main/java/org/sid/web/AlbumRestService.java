package org.sid.web;

import java.util.List;
import java.util.Optional;

import org.sid.dao.AlbumRepository;
import org.sid.entities.Album;
import org.sid.entities.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class AlbumRestService {
	@Autowired
	private AlbumRepository albumRepository;

	
	@RequestMapping(value="/album", method=RequestMethod.GET)
	public List<Album> getAlbum(){
		return albumRepository.findAll();
	} 
	@RequestMapping(value="/album/{id}", method=RequestMethod.GET)
	public Optional<Album> getAlbum(@PathVariable Long id){
		return albumRepository.findById(id);
		}
	@RequestMapping(value="/Album", method=RequestMethod.POST)
	public Album addAlbum(@RequestBody Album a){
		return albumRepository.save(a);
		}
	@RequestMapping(value="/album/{id}", method=RequestMethod.PUT)
	public Album updateAlbum(@PathVariable Long id, @RequestBody Album a){
			a.setId(id);
			return albumRepository.save(a);
					}
	@RequestMapping(value="/album/{id}", method=RequestMethod.DELETE)
	public boolean deleteAlbum(@PathVariable Long id){
		albumRepository.deleteById(id);
		return true;
	}
	/*@RequestMapping(value="/rechercherAlbum", method=RequestMethod.GET)
	public Page<Album> rechercher(
			@RequestParam(name="mc", defaultValue="") String mc,
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="6") int size){	
		return albumRepository.rechercher("%"+mc+"%", new PageRequest(page, size));
	}*/
}
