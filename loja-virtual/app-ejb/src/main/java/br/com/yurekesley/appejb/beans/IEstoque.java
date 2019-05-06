package br.com.yurekesley.appejb.beans;

import java.util.List;

import br.com.yurekesley.appejb.model.Produto;

public interface IEstoque {
	public List<Produto> getProdutosEmEstoque();

	public Integer getQuantidadeDeProdutosEmEstoque();

	public void removeDoEstoque(Produto produto) throws Exception;

	public void adicionarNoEstoque(Produto produto) throws Exception;
}
