package Q1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Selections extends Conect {
	
	private Statement st;

    public Statement start() {
        return super.start();
    }

    public void end() {
        super.end();
    }

    public void conectar() {

        try {
            st = start().getConnection().createStatement();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    
    public void searchBooks() throws SQLException, ClassNotFoundException {

        try {
            conectar();
            st.executeQuery("SELECT * FROM livro;");
            ResultSet search = st.getResultSet();
            while (search.next()) {

                System.out.println("Livro: " + search.getString("nm_titulo")+"\nValor: R$ " + search.getString("vl_preco"));
                end();
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);

        }

    }
    
    public void searchClient() throws SQLException, ClassNotFoundException {

        try {
            conectar();
            st.executeQuery("SELECT * FROM cliente;");
            ResultSet searchC = st.getResultSet();
            while (searchC.next()) {

                System.out.println("id: " + searchC.getString("id_cliente") + "\nNome: " + searchC.getString("nm_cliente") + "\nNumero: " + searchC.getString("nu_telefone_cliente"));
                end();
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);

        }

    }
    
    public void searchOrder(int id) throws SQLException,ClassNotFoundException{
        try {
            conectar();
            st.executeQuery("SELECT * FROM cliente WHERE id_cliente = "+id+";");
            ResultSet searchO = st.getResultSet();
            while (searchO.next()) {
                System.out.println("Nome: " + searchO.getString("nm_cliente"));
            }
            st.executeQuery("SELECT * FROM pedido where id_cliente = "+id+";");
            searchO = st.getResultSet();
            while (searchO.next()) {
                System.out.println("Valor do Pedido = : " + searchO.getString("vl_total_pago"));
                end();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);

        }
    }
    
    
}
