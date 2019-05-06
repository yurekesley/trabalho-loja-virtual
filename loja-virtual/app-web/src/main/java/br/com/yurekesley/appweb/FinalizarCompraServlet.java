package br.com.yurekesley.appweb;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.yurekesley.appejb.beans.ICarrinho;

@WebServlet("finalizar-compra")
public class FinalizarCompraServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICarrinho carrinho;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			try {
				this.carrinho.finalizarCompra();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			response.sendRedirect(request.getContextPath() + "/compras");

	}
	

}