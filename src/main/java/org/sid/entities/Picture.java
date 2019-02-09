package org.sid.entities;


import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table
public class Picture  implements Serializable{
	
	
		@Id @GeneratedValue
	private Long id;
	private String titre;
	private String image;
	private String description;
	 @ManyToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name="idUser")
	private User user;

	public Picture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Picture(String titre, String image, String description, String user) {
		super();
		this.titre = titre;
		this.image = image;
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Picture(User user) {
		super();
		this.user = user;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
}
