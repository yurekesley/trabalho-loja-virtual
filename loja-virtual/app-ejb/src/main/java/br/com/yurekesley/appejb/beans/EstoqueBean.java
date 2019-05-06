package br.com.yurekesley.appejb.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;

import br.com.yurekesley.appejb.model.Produto;

@Startup
@Singleton
@ApplicationScoped
public class EstoqueBean implements IEstoque {

	private List<Produto> produtos = new ArrayList<Produto>();

	@PostConstruct
	private void init() {
		Produto p1 = new Produto("P0001", "CD DREAM THEATER", 20.00);
		Produto p2 = new Produto("P0002", "BICICLITA", 1.000);
		Produto p3 = new Produto("P0003", "CAMISA DO BRASIL BRANCA", 50.00);
		Produto p4 = new Produto("P0004", "SABÃO CRA CRA", 1.50);
		this.produtos.addAll(Arrays.asList(p1, p2, p3, p4));
	}
	
	@Override
	public List<Produto> getProdutosEmEstoque() {
		return produtos;
	}

	@Override
	public Integer getQuantidadeDeProdutosEmEstoque() {
		if (this.produtos != null)
			return this.produtos.size();

		return 0;
	}

	@Override
	public void removeDoEstoque(Produto produto) throws Exception {

		if (this.produtos.contains(produto)) {
			this.produtos.remove(produto);
			return;
		}

		throw new Exception("Produto não está mais disponível no estoque !!!");
	}

	@Override
	public void adicionarNoEstoque(Produto produto) throws Exception {
		if (!this.produtos.contains(produto)) {
			this.produtos.add(produto);
			return;
		}

		throw new Exception("Produto já adicionado no estoque !!");

	}
	
	public Produto getProdutoPorID(String produtoID) {
	
			Produto encontrado = null;
		
			for (Produto produto : this.produtos) {
				if(produto.getCodigo().equals(produtoID)) {
					encontrado = produto;
					break;
				}
			}
		
		return encontrado;
	}


}