package com.example.sasta_rnc;

import com.example.sasta_rnc.Models.User;
import com.example.sasta_rnc.Repository.UserRepository;
import com.example.sasta_rnc.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SastaRncApplication {

	public static void main(String[] args) {
		SpringApplication.run(SastaRncApplication.class, args);
	}

}
