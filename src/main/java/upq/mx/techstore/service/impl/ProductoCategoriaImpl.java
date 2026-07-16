package upq.mx.techstore.service.impl;

import org.springframework.stereotype.Service;
import upq.mx.techstore.model.CategoriaDTO;
import upq.mx.techstore.service.ICategoriaService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoCategoriaImpl implements ICategoriaService {
	private final List<CategoriaDTO> categorias = new ArrayList<>();
	private Long id = 1L;

	@Override
	public List<CategoriaDTO> obtenerCategorias(){
		return categorias;
	}
	@Override
	public CategoriaDTO obtenerCategoria(Long id){
		return categorias.stream()
				.filter(categoria -> categoria.getId().equals(id))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No se encontro la categoria con el id: " + id));

	}

	@Override
	public CategoriaDTO guardarCategoria(CategoriaDTO categoria){
		categoria.setId(id++);
		categorias.add(categoria);
		return categoria;
	}

	@Override
	public CategoriaDTO actualizarCategoria(Long id, CategoriaDTO categoria){
		CategoriaDTO categoriaActualizada = obtenerCategoria(categoria.getId());
		categoriaActualizada.setNombre(categoria.getNombre());
		return categoriaActualizada;
	}

	@Override
	public void eliminarCategoria(Long id){
		CategoriaDTO categoriaid = obtenerCategoria(id);
		categorias.remove(categoriaid);
	}

}
