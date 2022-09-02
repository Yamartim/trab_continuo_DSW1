package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.ufscar.dc.dsw.domain.Cliente;

public class ClienteDAO extends GenericDAO{

	public void insert(Cliente cliente) {

        String sql = "INSERT INTO Cliente(email, senha, nome, CPF, adm, telefone, sexo, nascimento) VALUES "
        		+ "(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, cliente.getEmail());
            statement.setString(2, cliente.getSenha());
            statement.setString(3, cliente.getNome());
            statement.setString(4, cliente.getCPF());
            statement.setInt(5, cliente.getAdm());
            statement.setString(6, cliente.getTelefone());
            statement.setString(7, cliente.getSexo());
            statement.setString(8, cliente.getData_nascimento());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public List<Cliente> getAll() {

        List<Cliente> listaClientes = new ArrayList<>();

        String sql = "SELECT * from Cliente l order by l.id";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
            	
            	Long id = resultSet.getLong("id");
            	String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("nome");
                String CPF = resultSet.getString("CPF");
            	int adm = resultSet.getInt("adm");
            	String telefone = resultSet.getString("telefone");
                String sexo = resultSet.getString("sexo");
                String nascimento = resultSet.getString("nascimento");

                Cliente cliente = new Cliente(id, email, senha, nome, CPF, adm, telefone, sexo, nascimento);
                listaClientes.add(cliente);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaClientes;
    }
	
	public void delete(Cliente cliente) {
        String sql = "DELETE FROM Cliente where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, cliente.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public void update(Cliente cliente) {
        String sql = "UPDATE Cliente SET email = ?, senha = ?, nome = ?, CPF = ?";
        sql += ", adm = ?, telefone = ?, sexo = ?, nascimento = ? WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, cliente.getEmail());
            statement.setString(2, cliente.getSenha());
            statement.setString(3, cliente.getNome());
            statement.setString(4, cliente.getCPF());
            statement.setInt(5, cliente.getAdm());
            statement.setString(6, cliente.getTelefone());
            statement.setString(7, cliente.getSexo());
            statement.setString(8, cliente.getData_nascimento());
            statement.setLong(9, cliente.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
    public Cliente get(Long id) {
    	Cliente cliente = null;

        String sql = "SELECT * from Cliente c where c.id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	
            	String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("nome");
                String CPF = resultSet.getString("CPF");
            	int adm = resultSet.getInt("adm");
            	String telefone = resultSet.getString("telefone");
                String sexo = resultSet.getString("sexo");
                String nascimento = resultSet.getString("nascimento");
                
                cliente = new Cliente(id, email, senha, nome, CPF, adm, telefone, sexo, nascimento);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }
    
    public Cliente getbyLogin(String Email) {
    	Cliente cliente = null;

        String sql = "SELECT * from Cliente WHERE email = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, Email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	Long id = resultSet.getLong("id");
            	String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("nome");
                String CPF = resultSet.getString("CPF");
            	int adm = resultSet.getInt("adm");
            	String telefone = resultSet.getString("telefone");
                String sexo = resultSet.getString("sexo");
                String nascimento = resultSet.getString("nascimento");

                cliente = new Cliente(id, email, senha, nome, CPF, adm, telefone, sexo, nascimento);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }

}