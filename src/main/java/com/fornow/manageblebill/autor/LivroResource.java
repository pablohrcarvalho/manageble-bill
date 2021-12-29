package com.fornow.manageblebill.autor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroResource {

	private final LivroRepository livroRepository;

	public LivroResource (LivroRepository livroRepository){
		this.livroRepository = livroRepository;
	}

	@PostMapping("/save")
	public ResponseEntity<?> save (@RequestBody Livro livro){
		livroRepository.save(livro);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/fetch")
	public ResponseEntity<?> fetch (){
		List<Livro> livros = livroRepository.findAll();
		return ResponseEntity.ok(livros);
	}
}
