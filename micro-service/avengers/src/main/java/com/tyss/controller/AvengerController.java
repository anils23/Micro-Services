package com.tyss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.entity.Superheroes;
import com.tyss.feignclientcontroller.SuperHeroRestController;
import com.tyss.response.MyResponse;

@RestController
@RequestMapping("/avenger")
public class AvengerController {

	@Autowired
	private SuperHeroRestController controller;

//	@CircuitBreaker(name = "superhero-service", fallbackMethod = "response")
//	@Retry(name = "superhero-service", fallbackMethod = "response")
//	@RateLimiter(name = "superhero-service", fallbackMethod = "response")
//	@Bulkhead(name = "superhero-service", fallbackMethod = "response")
//	@TimeLimiter(name = "superhero-service")
	@GetMapping("/{id}")
	@Cacheable(value = "MyResponse", key = "#id")
	public MyResponse getSuperherodata(@PathVariable Integer id) {
			return MyResponse.builder().message("called from avengers")
				.data(controller.getSuperheroById(id).getBody().getData()).build();
	}

	@PostMapping("/add")
	@CachePut(value = "MyResponse", key = "#id")
	public MyResponse addSuperhero(@RequestBody Superheroes superheroes) {
		return MyResponse.builder().message("called from avengers")
				.data(controller.addSuperhero(superheroes).getBody().getData()).build();
	}

//	public MyResponse response(Exception e) {
//		return MyResponse.builder().data("Sorry buddy no data is present").message("Fallback method").build();
//	}
}
