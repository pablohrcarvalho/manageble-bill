package com.fornow.manageblebill.autor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/autor")
public class AutorResource {

	private final AutorRepository autorRepository;

	public AutorResource (AutorRepository autorRepository){
		this.autorRepository = autorRepository;
	}

	@GetMapping("/fetch")
	public ResponseEntity<?> fetch (){
		List<Autor> autores = autorRepository.findAll();
		return ResponseEntity.ok(autores);
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Autor autor){
		autorRepository.save(autor);
		return ResponseEntity.ok().build();
	}

}
