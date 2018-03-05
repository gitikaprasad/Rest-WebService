package com.jpa.ZaaxiitJpa.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.ZaaxiitJpa.model.Users;



public interface UserRepository extends JpaRepository<Users, Integer>{

	Optional<List<Users>> findByName(String name);
	

}
