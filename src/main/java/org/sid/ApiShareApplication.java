package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.UserRepository;
import org.sid.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiShareApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiShareApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		DateFormat df=new SimpleDateFormat("dd/mm/yyyy");
	userRepository.save(new User("Ambidina", "Moussa", df.parse("09/02/1988"), "moussa@gmail.com", "azerty", 0661010204, "image.jpg"));
	userRepository.save(new User("Assad", "adinane", df.parse("04/02/1990"), "assad@gmail.com", "azerty", 066120204, "image.jpg"));
	userRepository.save(new User("Simba", "Khaled", df.parse("09/06/1993"), "khaled@gmail.com", "azerty", 0663010204, "image.jpg"));
	userRepository.save(new User("Gunes", "Hakan", df.parse("09/05/1984"), "hakan@gmail.com", "azerty", 0661040204, "image.jpg"));
	userRepository.save(new User("Patrucci", "Thomas", df.parse("09/04/1985"), "thoma@gmail.com", "azerty", 0641010204, "image.jpg"));	
		
	userRepository.findAll().forEach(u->{
			System.out.println(u.getNom());
		});
	}

}

