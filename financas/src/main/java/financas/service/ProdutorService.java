package financas.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import financas.model.Produtor;

@ManagedBean
@ApplicationScoped
public class ProdutorService {
	private static List<Produtor> produtores = new ArrayList<>();
	
	public ProdutorService() {}
	
	public void add(Produtor produtor) {
		produtores.add(produtor);
	}
	
	public List<Produtor> getAll() {
		return produtores;
	}
	
	
	public Produtor get(Produtor produtor) {
		for (Produtor p : produtores) {
			if (p.equals(produtor)) {
				return p;
			}
		}
		return null;
	}

	public Produtor get(long id) {
		return get(new Produtor(id));
	}

	public boolean update(Produtor produtor) {
		Produtor _produtor = get(produtor);
		if (_produtor != null) {
			_produtor.setNome(produtor.getNome());
			_produtor.setCpf(produtor.getCpf());
			_produtor.setEmail(produtor.getEmail());
			_produtor.setTelefone(produtor.getTelefone());
			return true;
		}
		return false;
	}
	
	public boolean delete(long id) {
		Produtor _produtor = get(id);
		if (_produtor != null) {
			produtores.remove(_produtor);
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return produtores.toString();
	}
}

