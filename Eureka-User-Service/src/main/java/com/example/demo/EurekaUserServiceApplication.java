package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.UserDAO;
import com.example.demo.entity.User;

@SpringBootApplication
public class EurekaUserServiceApplication  implements CommandLineRunner{

	private UserDAO userDao;
	
	@Autowired
	public EurekaUserServiceApplication(UserDAO userDao) {
		super();
		this.userDao = userDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaUserServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userDao.save(new User("shivam", "test"));
		
	}

}
