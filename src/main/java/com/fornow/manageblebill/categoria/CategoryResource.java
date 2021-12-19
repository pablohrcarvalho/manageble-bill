package com.fornow.manageblebill.categoria;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryResource {

	private final CategoryRepository categoryRepository;

	Category category1;

	public CategoryResource(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@GetMapping("/fetch")
	public ResponseEntity<?> fetch() {
		List<Category> categorias = categoryRepository.findAll();
		return ResponseEntity.ok(categorias);
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Category category) {
		categoryRepository.save(category);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/delete")
	public ResponseEntity<?> delete(){
		categoryRepository.deleteById(category1.getId());
		return ResponseEntity.ok().build();
	}

	@PostMapping("/deleteAll")
	public ResponseEntity<?> deleteAll(){
		categoryRepository.deleteAll();
		return ResponseEntity.ok().build();
	}

}
