package com.inti.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Salon;
import com.inti.repositories.SalonRepository;
import com.inti.services.interfaces.ISalonService;

@Service
public class SalonService implements ISalonService{
	@Autowired
	SalonRepository salonRepository;
	
	@Override
	public List<Salon> findAll() {
		return salonRepository.findAll();
	}

	@Override
	public Salon findOne(Long id) {
		return salonRepository.findById(id).get();
	}

	@Override
	public Salon save(Salon salon) {
		return salonRepository.save(salon);
	}

	@Override
	public void delete(Long id) {
		salonRepository.deleteById(id);
		
	}

	@Override
	public Salon findByNom(String nom) {
		return salonRepository.findByNomSalon(nom);
	}

}
