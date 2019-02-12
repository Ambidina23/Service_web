package org.sid;

import org.sid.dao.PictureRepository;
import org.sid.entities.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiSharePicturesApplication implements CommandLineRunner{
	
	@Autowired
	
	private PictureRepository pictureRepository;
	public static void main(String[] args) {
		SpringApplication.run(ApiSharePicturesApplication.class, args);
		       /* BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16); // Strength set as 16
		        String encodedPassword = encoder.encode("UserPassword");
		        System.out.println("BCryptPasswordEncoder");
		        System.out.println(encodedPassword);
		        System.out.println("\n");*/
		   }
	

	@Override
	public void run(String... args) throws Exception {
		pictureRepository.save(new Picture("New work", "image.jpg", "c'etait parfait"));
		pictureRepository.save(new Picture("Vaccances", "image2.jpg", "très drole"));
		pictureRepository.save(new Picture("Au taquet", "image3.jpg", "merci mon cher"));
		pictureRepository.save(new Picture("Alors", "image4.jpg", "Tu viens ou pas?"));
		
		pictureRepository.findAll().forEach(p->{
			System.out.println(p.getTitre());
		});
		
		
		
	}

}

