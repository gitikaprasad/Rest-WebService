package com.jpa.ZaaxiitJpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.ZaaxiitJpa.Repo.UserLogRepository;
import com.jpa.ZaaxiitJpa.Repo.UserRepository;
import com.jpa.ZaaxiitJpa.model.UserContact;
import com.jpa.ZaaxiitJpa.model.Users;
import com.jpa.ZaaxiitJpa.model.UsersLog;

@RestController
@RequestMapping("/users")

public class UserContactController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserLogRepository userLogRepository;

	@GetMapping("/all")
	public List<Users> getAll() {
		return userRepository.findAll();
	}

	@GetMapping("/{name}")
	public List<Users> getUser(@PathVariable("name") final String name) {
		Optional<List<Users>> listOptional = userRepository.findByName(name);
		List<Users> users = listOptional.orElse(new ArrayList<Users>());
		return users;

	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Users> getId(@PathVariable("id") final Integer id) {
		Users user = userRepository.findOne(id);
		if(user==null)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(user);
	}

	@GetMapping("/update/{id}/{name}")
	public Users getId(@PathVariable("id") final Integer id, @PathVariable("name") final String name) {
		Users users = userRepository.findOne(id);
		users.setName(name);
		return userRepository.save(users);
	}

	@PostMapping("/add")
	public List<Users> add(@RequestBody Users users) {
		userRepository.save(users);
		return userRepository.findAll();
	}

	@GetMapping("log/all")
	public List<UsersLog> getAllLog() {
		return userLogRepository.findAll();
	}

	@GetMapping("/update/{name}")
	public List<Users> add(@PathVariable("name") final String name) {
		UsersLog userLog1 = new UsersLog();
		UsersLog userLog2 = new UsersLog();
		Users user = new Users();
		UserContact userContact = new UserContact();
		userLog1.setLog("Hi Youtube");
		userLog2.setLog("Hello World");
		userContact.setPhone(123456);
		user.setEmail("g@a.com");
		user.setName(name);
		user.setUserContact(userContact);
		user.setUserLogs(Arrays.asList(userLog1, userLog2));
		userRepository.save(user);
		return getAll();
	}

	@GetMapping("/{id}/{log}")
	public List<Users> addLog(@PathVariable("id") final Integer id, @PathVariable("log") final String log) {
		Users user = userRepository.findOne(id);
		user.getUserLogs().add(new UsersLog(log));
		userRepository.save(user);
		return getAll();
	}
	
	@GetMapping("/log/{id}")
	public List<UsersLog> getLog(@PathVariable("id") final Integer id) {
		Users user = userRepository.findOne(id);
		List<UsersLog>logs=user.getUserLogs();
		userRepository.save(user);
		return logs;
	}
	
	@GetMapping("/find/{log}")
	public List<Users> getUsers(@PathVariable("log") final String log) {
		List<Users> users,result=new ArrayList<Users>();		
		users=getAll();
		for(Users user:users)
		{
			for(UsersLog l: user.getUserLogs())
			{
				if(l.getLog().equals(log))
					result.add(user);
			}
		}
		return result;
		
	}
	
	@GetMapping("/del/{id}/{logno}")
	public List<Users> delUsers(@PathVariable("id") final int id,@PathVariable("logno") final int logno) {
		Users user=userRepository.findOne(id);		
		user.getUserLogs().remove(logno-1);	
		userRepository.save(user);
		return getAll();
	}
	
	@GetMapping("/del/{id}")
	public List<Users> delId(@PathVariable(name="id")final Integer id)
	{
		Users user=userRepository.findOne(id);
		userRepository.delete(user);
		return getAll();
		
	}
}
