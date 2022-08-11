package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Prestador;

public class PrestadorDAO extends GenericDAO {
	
	public void insert(Prestador prestador) {

        String sql = "INSERT INTO Prestador(email, senha, nome, CPF, area, especialidade) VALUES "
        		+ "(?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, prestador.getEmail());
            statement.setString(2, prestador.getSenha());
            statement.setString(3, prestador.getNome());
            statement.setString(4, prestador.getCPF());
            statement.setString(5, prestador.getArea());
            statement.setString(6, prestador.getEspecialidade());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public List<Prestador> getAll() {

        List<Prestador> listaPrestador = new ArrayList<>();

        String sql = "SELECT * from Prestador p order by p.id";

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
                String area = resultSet.getString("area");
                String especialidade = resultSet.getString("especialidade");

                Prestador prestador = new Prestador(id, email, senha, nome, CPF, area, especialidade);
                listaPrestador.add(prestador);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPrestador;
    }
	
	public void delete(Prestador prestador) {
        String sql = "DELETE FROM Prestador where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, prestador.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public void update(Prestador prestador) {
        String sql = "UPDATE Prestador SET email = ?, senha = ?, nome = ?, CPF = ?";
        sql += ", area = ?, especialidade = ? WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, prestador.getEmail());
            statement.setString(2, prestador.getSenha());
            statement.setString(3, prestador.getNome());
            statement.setString(4, prestador.getCPF());
            statement.setString(7, prestador.getArea());
            statement.setString(8, prestador.getEspecialidade());

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
    public Prestador get(Long id) {
    	Prestador prestador = null;

        String sql = "SELECT * from Prestador p where p.id = ?";

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
                String area = resultSet.getString("area");
                String especialidade = resultSet.getString("especialidade");
                
                prestador = new Prestador(id, email, senha, nome, CPF, area, especialidade);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return prestador;
    }
    
    public Prestador getbyLogin(String Email) {
    	Prestador prestador = null;

        String sql = "SELECT * from Prestador WHERE email = ?";

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
                String area = resultSet.getString("area");
                String especialidade = resultSet.getString("especialidade");

                prestador = new Prestador(id, email, senha, nome, CPF, area, especialidade);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return prestador;
    }

}
