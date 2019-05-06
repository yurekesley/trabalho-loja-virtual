package br.com.yurekesley.appweb;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.yurekesley.appejb.beans.ICarrinho;
import br.com.yurekesley.appejb.beans.IEstoque;
import br.com.yurekesley.appejb.model.Produto;

public class RemoverDoCarrinhoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICarrinho carrinho;
	
	@Inject
	private IEstoque estoque;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String produtoID = request.getParameter("produtoID");
		
		if(!produtoID.equals("") != produtoID.equals(null)) {
			Produto produto = this.estoque.getProdutoPorID(produtoID);				
			try {
				this.carrinho.removerProduto(produto);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		response.sendRedirect(request.getContextPath() + "/compras");
		
	}

}