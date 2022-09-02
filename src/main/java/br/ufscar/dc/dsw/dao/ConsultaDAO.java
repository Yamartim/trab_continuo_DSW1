package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Consulta;
import br.ufscar.dc.dsw.domain.Prestador;

public class ConsultaDAO extends GenericDAO{

	public ClienteDAO daocliente;
	public PrestadorDAO daoprestador;

	public void insert(Consulta consulta) {

        String sql = "INSERT INTO Consulta(idcliente, idprestador, data, estado) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, consulta.getCliente().getId());
            statement.setLong(2, consulta.getPrestador().getId());
            statement.setString(3, consulta.getData());
            statement.setString(4, consulta.getEstado());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public void delete(Consulta consulta) {
        String sql = "DELETE FROM Consulta where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, consulta.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public void update(Consulta consulta) {
        String sql = "UPDATE Consulta SET idcliente = ?, idprestador = ?, data = ?, estado = ? WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setLong(1, consulta.getCliente().getId());
            statement.setLong(2, consulta.getPrestador().getId());
            statement.setString(3, consulta.getData());
            statement.setString(4, consulta.getEstado());
            statement.setLong(5, consulta.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	
	public List<Consulta> getAllbyCliente(Long idC) {

        List<Consulta> listaConsulta = new ArrayList<>();
        daocliente = new ClienteDAO();
        daoprestador = new PrestadorDAO();

        String sql = "SELECT * from Consulta WHERE idcliente = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, idC);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	
            	Long id = resultSet.getLong("id");
            	Long idcliente = resultSet.getLong("idcliente");
            	Long idprestador = resultSet.getLong("idprestador");
                String data = resultSet.getString("data");
                String estado = resultSet.getString("estado");

                Cliente clienteConsulta = daocliente.get(idcliente);
                Prestador prestadorConsulta = daoprestador.get(idprestador);

                Consulta consulta = new Consulta(id, clienteConsulta, prestadorConsulta, data, estado);
                listaConsulta.add(consulta);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(listaConsulta.isEmpty()) {
        	return null;
        } else {
        	return listaConsulta;
        }
        
    }
	
	/*public List<Consulta> getAllbyPrestador(Long idP) {

        List<Consulta> listaConsulta = new ArrayList<>();

        String sql = "SELECT * from Consulta c where idprestador = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setLong(1, idP);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	
            	Long id = resultSet.getLong("id");
            	Long idcliente = resultSet.getLong("idcliente");
            	Long idprestador = resultSet.getLong("idcliente");
                String data = resultSet.getString("data");
                String estado = resultSet.getString("estado");
                
                Cliente clienteConsulta = daocliente.get(idcliente);
                Prestador prestadorConsulta = daoprestador.get(idprestador);

                Consulta consulta = new Consulta(id, clienteConsulta, prestadorConsulta, data, estado);
                listaConsulta.add(consulta);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaConsulta;
    }*/
	
}
