package financas.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import financas.model.Categoria;

@ManagedBean
@ApplicationScoped
public class CategoriaService {
	private static List<Categoria> categorias = new ArrayList<>();
	
	public CategoriaService() {}
	
	public void add(Categoria categoria) {
		categorias.add(categoria);
	}
	
	public List<Categoria> getAll() {
		return categorias;
	}
	
	
	public Categoria get(Categoria categoria) {
		for (Categoria c : categorias) {
			if (c.equals(categoria)) {
				return c;
			}
		}
		return null;
	}

	public Categoria get(long id) {
		return get(new Categoria(id, null));
	}

	public boolean update(Categoria categoria) {
		Categoria _categoria = get(categoria);
		if (_categoria != null) {
			_categoria.setNome(categoria.getNome());
			return true;
		}
		return false;
	}
	
	public boolean delete(long id) {
		Categoria _categoria = get(id);
		if (_categoria != null) {
			categorias.remove(_categoria);
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return categorias.toString();
	}
}

