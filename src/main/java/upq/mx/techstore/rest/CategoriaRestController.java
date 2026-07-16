package upq.mx.techstore.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upq.mx.techstore.model.CategoriaDTO;
import upq.mx.techstore.service.ICategoriaService;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@ControllerAdvice
public class CategoriaRestController {
	private final ICategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> obtenerCategorias(){
		List<CategoriaDTO> categorias = categoriaService.obtenerCategorias();
		return ResponseEntity.ok(categorias);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDTO> obtenerCategoria(@PathVariable Long id){
		CategoriaDTO categoria = categoriaService.obtenerCategoria(id);
		return ResponseEntity.ok(categoria);
	}

	@PostMapping
	public ResponseEntity<CategoriaDTO> guardarCategoria(@RequestBody CategoriaDTO categoria){
		CategoriaDTO guardada = categoriaService.guardarCategoria(categoria);
		return ResponseEntity.ok(guardada);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoriaDTO> actualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoria){
		CategoriaDTO actualizada = categoriaService.actualizarCategoria(id, categoria);
		 return ResponseEntity.ok(actualizada);
	}

	@DeleteMapping("/{id}")
	public void eliminarCategoria(@PathVariable Long id){
		categoriaService.eliminarCategoria(id);
	}
}
