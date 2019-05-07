package br.com.yurekesley.appweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.yurekesley.appejb.beans.ICarrinho;
import br.com.yurekesley.appejb.beans.IEstoque;
import br.com.yurekesley.appejb.model.Produto;

@SessionScoped
@WebServlet("/compras")
public class ComprasServlet extends HttpServlet {

	@Inject
	private ICarrinho carrinho;
	
	@Inject
	private IEstoque estoque;
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		writer.append("<html>");
		writer.append("<body>");

		writer.append("<h1>Lista de Produtos Disponíveis.</h1>");

		writer.append("<table>");
		writer.append("<tr>");
		writer.append("<th>");
		writer.append("Código");
		writer.append("</th>");
		writer.append("<th>");
		writer.append("Produto");
		writer.append("</th>");
		writer.append("<th>");
		writer.append("</th>");
		writer.append("</tr>");

		for (Produto produto : this.estoque.getProdutosEmEstoque()) {
			writer.append("<tr>");
			writer.append("<td>");
			writer.append(produto.getCodigo());
			writer.append("</td>");
			writer.append("<td>");
			writer.append(produto.getNome());
			writer.append("</td>");

			writer.append("<td>");

			writer.append("<form action=\"produtos\" method=\"GET\">");

			String link = "<a href=\"carrinho?produtoID=" + produto.getCodigo() + "\"> Adicionar ao Carrinho </a>";

			writer.append(link);
			writer.append("</td>");

			writer.append("</tr>");

		}

		writer.append("</table>");

		writer.append("<h3>Quantidade de produtos em estoque: " + this.estoque.getQuantidadeDeProdutosEmEstoque() + "</h3>");

		writer.append("</ br></ br></ br>");

		writer.append("<h1>Lista de Produtos No Carrinho</h1>");

		writer.append("<table>");
		writer.append("<tr>");
		writer.append("<th>");
		writer.append("Código");
		writer.append("</th>");
		writer.append("<th>");
		writer.append("Produto");
		writer.append("</th>");
		writer.append("<th>");
		writer.append("</th>");
		writer.append("</tr>");

		for (Produto produto : this.carrinho.getProdutos()) {
			writer.append("<tr>");
			writer.append("<td>");
			writer.append(produto.getCodigo());
			writer.append("</td>");
			writer.append("<td>");
			writer.append(produto.getNome());
			writer.append("</td>");

			writer.append("<td>");

			writer.append("<form action=\"produtos\" method=\"GET\">");

			String link = "<a href=\"remover-do-carrinho?produtoID=" + produto.getCodigo()
					+ "\"> Remover do Carrinho Carrinho </a>";

			writer.append(link);
			writer.append("</td>");
			writer.append("</tr>");
		}

		writer.append("</ br></ br></ br>");
		writer.append("<h1>Finalizar Compra</h1>");

		String link2 = "<a href=\"finalizar-compra\"> Finalizar compra </a>";
		writer.append(link2);

		writer.append("</ br></ br></ br>");

		writer.append("</body>");
		writer.append("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}