import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/oi")
public class MeuServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, 
			HttpServletResponse response)  throws IOException {			
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String CPF = request.getParameter("CPF");
		String RG = request.getParameter("rg");
				
		out.println( "<html>");
		out.println( "<body>");		
		out.println( "<p><h1> Meu Primeiro Servlet &&8*** </h1></p>");
		out.println( "<p>" + nome + "</p>");
		out.println( "<p>" + CPF + "</P");
		out.println( "<p>" + RG + "</p>");
		out.println( "</body>");
		out.println( "</html>");			
	}
}
