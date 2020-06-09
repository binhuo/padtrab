package financas.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import financas.model.Produto;

@ManagedBean
@ApplicationScoped
public class ProdutoService {
	private static List<Produto> produtos = new ArrayList<>();
	
	public ProdutoService() {}
	
	public void add(Produto produto) {
		produtos.add(produto);
	}
	
	public List<Produto> getAll() {
		return produtos;
	}	
	
	public Produto get(Produto produto) {
		for (Produto p : produtos) {
			if (p.equals(produto)) {
				return p;
			}
		}
		return null;
	}

	public Produto get(long id) {
		return get(new Produto(id));
	}

	public boolean update(Produto produto) {
		Produto _produto = get(produto);
		if (_produto != null) {
			_produto.setNome(produto.getNome());
			return true;
		}
		return false;
	}
	
	public boolean delete(long id) {
		Produto _produto = get(id);
		if (_produto != null) {
			produtos.remove(_produto);
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return produtos.toString();
	}
}

