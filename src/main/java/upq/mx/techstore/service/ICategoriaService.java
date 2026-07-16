package upq.mx.techstore.service;

import upq.mx.techstore.model.CategoriaDTO;

import java.util.List;

public interface ICategoriaService {
	List<CategoriaDTO> obtenerCategorias();
	CategoriaDTO obtenerCategoria(Long id);
	CategoriaDTO guardarCategoria(CategoriaDTO categoria);
	CategoriaDTO actualizarCategoria(Long id, CategoriaDTO categoria);
	void eliminarCategoria(Long id);
}
