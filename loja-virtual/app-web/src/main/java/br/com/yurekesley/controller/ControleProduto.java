package br.com.yurekesley.controller;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import br.com.yurekesley.appejb.beans.IEstoque;
import br.com.yurekesley.appejb.model.Produto;

@ManagedBean
public class ControleProduto  {

	@Inject
	private IEstoque estoque;

	public List<Produto> getProdutosEmEstoque() {
		return this.estoque.getProdutosEmEstoque();
	}

	public Integer getQuantidadeProdutosEmEstoque() {
		return this.estoque.getQuantidadeDeProdutosEmEstoque();
	}
}