package financas.model;

public class Produto extends AbstractEntity{
    public String nome;
    public Categoria categoria;
    public String unidade;
    public float preco;
    public float precoMercado;
    public float precoLojinha;
    
    public Produto(){
        
    }
    
    public Produto(long id){
        
    }

    public Produto(long id, String nome, Categoria categoria, String unidade, float preco, float precoMercado, float precoLojinha) {
    	this.id = id;
    	this.nome = nome;
        this.categoria = categoria;
        this.unidade = unidade;
        this.preco = preco;
        this.precoMercado = precoMercado;
        this.precoLojinha = precoLojinha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getPrecoMercado() {
        return precoMercado;
    }

    public void setPrecoMercado(float precoMercado) {
        this.precoMercado = precoMercado;
    }

    public float getPrecoLojinha() {
        return precoLojinha;
    }

    public void setPrecoLojinha(float precoLojinha) {
        this.precoLojinha = precoLojinha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + Float.floatToIntBits(preco);
		result = prime * result + Float.floatToIntBits(precoLojinha);
		result = prime * result + Float.floatToIntBits(precoMercado);
		result = prime * result + ((unidade == null) ? 0 : unidade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Float.floatToIntBits(preco) != Float.floatToIntBits(other.preco))
			return false;
		if (Float.floatToIntBits(precoLojinha) != Float.floatToIntBits(other.precoLojinha))
			return false;
		if (Float.floatToIntBits(precoMercado) != Float.floatToIntBits(other.precoMercado))
			return false;
		if (unidade == null) {
			if (other.unidade != null)
				return false;
		} else if (!unidade.equals(other.unidade))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", categoria=" + categoria + ", unidade=" + unidade + ", preco=" + preco + ", precoMercado=" + precoMercado + ", precoLojinha=" + precoLojinha + '}';
    }
}
