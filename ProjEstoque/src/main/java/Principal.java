import javax.swing.JOptionPane;

import br.edu.unicid.bean.Produto;
import br.edu.unicid.dao.ProdutoDAO;

public class Principal {

	public static void main(String[] args) {
		
		try {
			ProdutoDAO dao = new ProdutoDAO();
			
			Produto produto = new Produto(7,"Controle","Sony",5);
//			dao.salvar(produto);
//			dao.atualizar(produto);
//			dao.excluir(produto);
//			dao.procurarProduto(7);
			dao.todosProdutos();
			System.out.println(dao.procurarProduto(7).getCodigo());
			System.out.println(dao.procurarProduto(7).getNome());
			System.out.println(dao.procurarProduto(7).getDescricao());
			System.out.println(dao.procurarProduto(7).getQuantidade());
			
			
			JOptionPane.showMessageDialog(null, produto);
		} catch (Exception e){
			e.printStackTrace();
		}

	}

}
