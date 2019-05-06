package br.com.yurekesley.appejb.beans;

import java.util.List;

import javax.ejb.Local;

import br.com.yurekesley.appejb.model.Produto;

@Local
public interface ICarrinho {
	
	public void adcionarProduto(Produto produto);

	public void removerProduto(Produto removerProduto) throws Exception;
	
	public List<Produto> getProdutos();
	
	public void finalizarCompra() throws Exception;
	
}