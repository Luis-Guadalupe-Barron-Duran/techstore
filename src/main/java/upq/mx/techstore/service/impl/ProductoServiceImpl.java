package upq.mx.techstore.service.impl;

import org.springframework.stereotype.Service;
import upq.mx.techstore.model.ProductoDTO;
import upq.mx.techstore.service.IProductoService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {
	private final List<ProductoDTO> productos = new ArrayList<>();
	private Long id = 1L;

	@Override
	public List<ProductoDTO> obtenerProductos() {
		return productos;
	}

	@Override
	public ProductoDTO obtenerProducto(Long id){
		return productos.stream()
				.filter(producto -> producto.getId().equals(id))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No se encontro el producto con el id: " + id));
	}

	@Override
	public ProductoDTO guardarProducto(ProductoDTO producto){
		producto.setId(id++);
		productos.add(producto);
		return producto;
	}

	@Override
	public ProductoDTO actualizarProducto(Long id, ProductoDTO producto){
		ProductoDTO productoActualizado = obtenerProducto(id);
		productoActualizado.setNombre(producto.getNombre());
		productoActualizado.setPrecio(producto.getPrecio());
		productoActualizado.setStock(producto.getStock());
		productoActualizado.setSku(producto.getSku());
		return productoActualizado;

	}

	@Override
	public void eliminarProducto(Long id){
		ProductoDTO producto = obtenerProducto(id);
		productos.remove(producto);
	}


}
