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
import upq.mx.techstore.model.ProductoDTO;
import upq.mx.techstore.exception.NoEncontrado;
import upq.mx.techstore.service.IProductoService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@ControllerAdvice
public class ProductoRestController {

	private final IProductoService productoService;

	@GetMapping
	public ResponseEntity<List<ProductoDTO>> obtenerProductos(){
		List<ProductoDTO> productos = productoService.obtenerProductos();
		return ResponseEntity.ok(productos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductoDTO> obtenerProducto(@PathVariable Long id){
		ProductoDTO producto = productoService.obtenerProducto(id);
		if (producto == null) {
			throw new NoEncontrado("No se encontro el producto con el id: " + id);
		}
		return ResponseEntity.ok(producto);
	}

	@PostMapping
	public ResponseEntity<ProductoDTO> guardarProducto(@RequestBody ProductoDTO producto){
		ProductoDTO productoGuardado = productoService.guardarProducto(producto);
		return ResponseEntity.ok(productoGuardado);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductoDTO> actualizarProducto(@PathVariable Long id, @RequestBody ProductoDTO producto){
		ProductoDTO productoActualizado = productoService.actualizarProducto(id, producto);
		return ResponseEntity.ok(productoActualizado);
	}

	@DeleteMapping("/{id}")
	public void eliminarProducto(@PathVariable Long id){
		productoService.eliminarProducto(id);
	}

}
