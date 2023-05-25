package com.inti.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.inti.entities.Avis;
import com.inti.services.interfaces.IAvisService;

@Controller
@CrossOrigin
public class AvisController {
	@Autowired
	IAvisService avisService;

	@GetMapping("/aviss")
	public List<Avis> findAll() {
		return avisService.findAll();
	}

	@GetMapping("/aviss/{idAvis}")
	public Avis findOne(@PathVariable("idAvis") Long id) {
		return avisService.findOne(id);
	}

	@PostMapping("/aviss")
	public Avis saveAvis(@RequestBody Avis avis) {
		return avisService.save(avis);
	}

	@DeleteMapping("/aviss/{idAvis}")
	public void deleteAvis(@PathVariable("idAvis") Long id) {
		avisService.delete(id);
	}

	@PutMapping("/aviss/{idAvis}")
	public Avis updateAvis(@PathVariable("idAvis") Long id, @RequestBody Avis avis) {
		Avis currentAvis = avisService.findOne(id);
		currentAvis.setTitre(avis.getTitre());
		currentAvis.setDescription(avis.getDescription());
		return avisService.save(currentAvis);
	}
}
