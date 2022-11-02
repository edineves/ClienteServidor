<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href = "estilo.css" />
        <title>Consultar Produtos</title>
    </head>
   <body>
        <h2 align="center">Consulta de Produtos</h2>
        <jsp:useBean id="produto" scope="session" class="br.edu.unicid.bean.Produto" />
		<% SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy"); %>
        <form>
            <center>
            <table>
                <tr>
                    <td>Código:</td>
                    <td>
                        <input type="text" maxlength="60"  size = "60" name="txtNome" 
                        value="<%=produto.getCodigo()%>" readonly="readonly" />
                    </td>
                </tr>
                <tr>
                    <td>Nome:</td>
                    <td>
                        <input type="text" maxlength="60"  size = "60" name="txtNome" 
                        value="<%=produto.getNome()%>" readonly="readonly" />
                    </td>
                </tr>
                <tr>
                    <td>Descrição:</td>
                    <td>
                        <input type="text" maxlength="60"  size = "60" name="txtEmail" 
					value="<%=produto.getDescricao()%>" readonly="readonly" />
                    </td>
                </tr>
                <tr>
                    <td>Quantidade:</td>
                    <td>
                        <input type="text" maxlength="60"  size = "60" name="txtEmail" 
					value="<%=produto.getQuantidade()%>" readonly="readonly" />
                    </td>
                </tr>
				<tr>
					<td colspan="2" align="center"><a href="index.jsp">Página Principal</a></td>
				</tr>             
             </table>
            </center>
        </form>
    </body>
</html>