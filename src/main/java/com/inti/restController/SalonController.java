package com.inti.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Salon;
import com.inti.services.interfaces.ISalonService;

@RestController
@CrossOrigin
public class SalonController {
	@Autowired
	ISalonService salonService;
	
	@GetMapping("/roles")
	public List<Salon> findAll() {
		return salonService.findAll();
	}
}
