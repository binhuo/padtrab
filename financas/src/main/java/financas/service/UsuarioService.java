package financas.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import financas.model.Usuario;

@ManagedBean
@ApplicationScoped
public class UsuarioService{
private static List<Usuario> usuarios = new ArrayList<>();
	
	public UsuarioService() {}
	
	public void add(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public List<Usuario> getAll() {
		return usuarios;
	}
	
	public Usuario get(Usuario usuario) {
		for (Usuario u : usuarios) {
			if (u.equals(usuario)) {
				return u;
			}
		}
		return null;
	}

	public Usuario get(long id) {
		return get(new Usuario(id));
	}
	
	public boolean update(Usuario usuario) {
		Usuario _usuario = get(usuario);
		if (_usuario != null) {
			_usuario.setNome(usuario.getNome());
			_usuario.setEmail(usuario.getEmail());
			_usuario.setSenha(usuario.getSenha());
			return true;
		}
		return false;
	}
	
	public boolean delete(Long id) {
		Usuario usuario = get(id);
		if (usuario != null) {
			usuarios.remove(usuario);
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return usuarios.toString();
	}
    
}
