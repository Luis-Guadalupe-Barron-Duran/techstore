package upq.mx.techstore.service;

import upq.mx.techstore.model.ProductoDTO;

import java.util.List;

public interface IProductoService {
	List<ProductoDTO> obtenerProductos();
	ProductoDTO obtenerProducto(Long id);
	ProductoDTO guardarProducto(ProductoDTO producto);
	ProductoDTO actualizarProducto(Long id, ProductoDTO producto);
	void eliminarProducto(Long id);
}
