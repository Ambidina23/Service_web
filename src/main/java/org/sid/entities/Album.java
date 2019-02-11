package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Album implements Serializable {
	@Id @GeneratedValue
	private Long id;
	private String nom;
	@OneToMany()
	private Collection<Picture> pictures;
	public Album() {
		super();
	}
	
	public Album(String nom, Collection <Picture> pictures ) {
		this.nom=nom;
		this.pictures=pictures;
		
	}
	public void setId(Long id) {
		this.id=id;
	}
	
	public void setNom(String nom) {
		this.nom=nom;
	}
	public void setPicture(Collection<Picture> pictures) {
		this.pictures=pictures;
	}
	public Long getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public Collection<Picture> getPictures(){
		return pictures;
	}

}
