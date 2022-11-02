<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="br.edu.unicid.bean.Produto" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>


<html>
<head>
<title>Lista Produtos</title>
</head>
<body>
	<center>
	<table width= "100%" border="1" cellpadding="2" cellspacing="0">
		<tr>
			<th colspan="6"><h3>Lista de Produtos</h3></th>
		
		</tr>
		<tr>
			<th>ID - Atualizar</th>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Nascimento</th>
			<th>Idade</th>
			<th>Endereço</th>
		</tr>
          	<%
          		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
                List <Produto> lista = new ArrayList<Produto>();
                lista = (ArrayList) request.getAttribute("alunosList");
                for(Produto a: lista ){%>
			<tr>
				<td><%=a.getCodigo()%></td>
				<td><%=a.getNome()%></td>
				<td><%=a.getDescricao()%></td>
				<td><%=a.getQuantidade()%></td>
			</tr>
            <%
                }
          %>
		<tr>
			<td colspan="6" align="center"><a href="index.jsp">Página Principal</a></td>
		</tr>	
	</table>
	</center>
	</body>
</html>