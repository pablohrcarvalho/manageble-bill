package com.fornow.manageblebill.categoria;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryResource {

	private final CategoryRepository categoryRepository;

	public CategoryResource(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@GetMapping("/fetch")
	public ResponseEntity<?> fetch() {
		List<Category> categorias = categoryRepository.findAll();
		return ResponseEntity.ok(categorias);
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<?> fetchId(@PathVariable("id") String id) {
		Optional<Category> categorias = categoryRepository.findById(Long.parseLong(id));
		return ResponseEntity.ok(categorias);
	}

	@GetMapping("/fetchByDescription/{description}")
	public ResponseEntity<?> fetchByDescription(@PathVariable("description") String description) {
		List<Category> categories = categoryRepository.findAllByDescription(description);
		return ResponseEntity.ok(categories);
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Category category) {
		categoryRepository.save(category);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id){
		categoryRepository.deleteById(Long.parseLong(id));
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/deleteAll")
	public ResponseEntity<?> deleteAll(){
		categoryRepository.deleteAll();
		return ResponseEntity.ok().build();
	}

}
