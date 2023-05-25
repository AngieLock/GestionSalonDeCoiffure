package com.inti.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Salon;
import com.inti.services.interfaces.ISalonService;

@RestController
@CrossOrigin
public class SalonController {
	@Autowired
	ISalonService salonService;
	
	@GetMapping("/salons")
	public List<Salon> findAll() {
		return salonService.findAll();
	}
	@GetMapping("/salons/{idSalon}")
	public Salon findOne(@PathVariable("idSalon") Long id) {
		return salonService.findOne(id);
	}
	@PostMapping("/salons")
	public Salon saveSalon(@RequestBody Salon salon) {
		return salonService.save(salon);
	}
	@DeleteMapping("/salons/{idSalon}")
	public void deleteSalon(@PathVariable("idSalon") Long id) {
		salonService.delete(id);
	}
	@PutMapping("/salons/{idSalon}")
	public Salon updateSalon(@PathVariable("idSalon") Long id, @RequestBody Salon salon) {
		Salon currentSalon = salonService.findOne(id);
		currentSalon.setNomSalon(salon.getNomSalon());
		currentSalon.setAdresse(salon.getAdresse());
		currentSalon.setReservation(salon.getReservation());
		return salonService.save(currentSalon);
	}
}
