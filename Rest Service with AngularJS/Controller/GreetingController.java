package com.rest.ZaaxiRest;

import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class GreetingController {
	private static final Logger logger=Logger.getLogger(App.class);

	@Autowired
	UserRepository userRepository;

	@GetMapping("/all")
	public List<Users> getAll() {
		logger.info("showing all the users");
		return userRepository.findAll();
	}

	@PostMapping("/add")
	public List<Users> add(@RequestBody Users users) {
		System.out.println("adding...");
		userRepository.save(users);
		return getAll();
	}

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		logger.info("Greeting you");
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	public void saveDOB(@RequestBody MyDTO myDTO,HttpServletRequest httprequest,HttpServletResponse httpResponse) {
		System.out.println("Inside Controller");
	}
	
}