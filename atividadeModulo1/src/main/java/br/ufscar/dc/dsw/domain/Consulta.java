package br.ufscar.dc.dsw.domain;

public class Consulta {
	
	private Long id;
	private Cliente cliente;
    private Prestador prestador;
    private String data;
    private String estado;
    
    
	public Consulta(Long id, Cliente cliente, Prestador prestador, String data, String estado) {
		
		super();
		this.id = id;
		this.cliente = cliente;
		this.prestador = prestador;
		this.data = data;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Prestador getPrestador() {
		return prestador;
	}

	public void setPrestador(Prestador prestador) {
		this.prestador = prestador;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
