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
		pictureRepository.save(new Picture("New work", "/apiShare2/src/main/resources/image/boat_01.jpeg", "c'etait parfait", "moussa"));
		pictureRepository.save(new Picture("Vaccances", "/apiShare2/src/main/resources/image/boat_03.jpeg", "très drole","sema"));
		pictureRepository.save(new Picture("Au taquet", "/apiShare2/src/main/resources/image/boat_04.jpeg", "merci mon cher","thomas"));
		pictureRepository.save(new Picture("Alors", "/apiShare2/src/main/resources/image/camping_01.jpeg", "Tu viens ou pas?", "jennifer"));
		
		
		pictureRepository.findAll().forEach(p->{
			System.out.println(p.getTitre());
		});
		
		
		
	}

}

