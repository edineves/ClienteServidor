package br.edu.unicid.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.edu.unicid.bean.Produto;
import br.edu.unicid.dao.ProdutoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ServletProdutos")
public class ServletProdutos extends HttpServlet {
	
	// m�todo para convers�o de String para data
    private Date strToDate(String data) throws Exception {
        if (data == null) {
            return null;
        }

        Date dataF = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            long timestamp = dateFormat.parse(data).getTime();
            dataF = new Date(timestamp);
        } catch (ParseException pe) {
            throw pe;
        }
        return dataF;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // a vari�vel cmd indica o tipo de a��o - incluir, alterar, consulta.....
        String cmd = request.getParameter("cmd");
        // cria um objeto dao - CRUD
        ProdutoDAO dao;
        // cria um objeto do tipo aluno
        Produto produto = new Produto(0, cmd, cmd, 0);
        if (cmd != null) {
            try {
                // inicializa os atributos da classe Produtos
            	produto.setCodigo(Integer.parseInt(request.getParameter("txtCodigo")));
            	produto.setNome(request.getParameter("txtNome"));
            	produto.setDescricao(request.getParameter("txtDescricao"));
            	produto.setQuantidade(Integer.parseInt(request.getParameter("txtQuantidade")));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        try {
        	// cria a instancia do objeto dao
            dao = new ProdutoDAO();
            RequestDispatcher rd = null;
            // lista todos os produtos
            if (cmd.equalsIgnoreCase("listar")) {
                List produtoList = dao.todosProdutos();
                // cria uma sess�o para encaminhar a lista para uma JSP
                request.setAttribute("produtoList", produtoList);
                // redireciona para a JSP mostraAlunosCads
                rd = request.getRequestDispatcher("/mostrarProdutosCads.jsp");
            }
            
            // incluir produto
            else if (cmd.equalsIgnoreCase("incluir")) {
                dao.salvar(produto);
                rd = request.getRequestDispatcher("ServletProdutos?cmd=listar");
             
            // consulta produto para exclus�o    
            } else if (cmd.equalsIgnoreCase("exc")) {
                produto = dao.procurarProduto(produto.getCodigo());
                HttpSession session = request.getSession(true);
                session.setAttribute("produto", produto);
                rd = request.getRequestDispatcher("/formExcAluno.jsp");
             
            // exclui produto
            } else if (cmd.equalsIgnoreCase("excluir")) {
                dao.excluir(produto);
                rd = request.getRequestDispatcher("ServletProduto?cmd=listar");
            
            // consulta produto para altera��o
            }  else if (cmd.equalsIgnoreCase("atu")) {
            	produto = dao.procurarProduto(produto.getCodigo());
                HttpSession session = request.getSession(true);
                session.setAttribute("produto", produto);
                rd = request.getRequestDispatcher("/formAtuProduto.jsp");
             
            // consulta produto
            } else if (cmd.equalsIgnoreCase("con")) {
            	produto = dao.procurarProduto(produto.getCodigo());
                HttpSession session = request.getSession(true);
                session.setAttribute("produto", produto);
                rd = request.getRequestDispatcher("/formConsProduto.jsp");
            
             // altera produto    
            } else if (cmd.equalsIgnoreCase("atualizar")) {
                dao.atualizar(produto);
                rd = request.getRequestDispatcher("ServletProdutos?cmd=listar");
            
            // direciona para a p�gina principal
            } else if (cmd.equalsIgnoreCase("principal")) {
                rd = request.getRequestDispatcher("/index.jsp");
            }            
            // executa a a��o de direcionar para a p�gina JSP
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
}