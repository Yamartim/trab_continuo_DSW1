package br.ufscar.dc.dsw.domain;

public class Prestador extends BaseUser{

	private String area;
    private String especialidade;
    //????????? curriculo em PDF;
	
    public Prestador(Long id, String email, String senha, String nome, String cPF, String area, String especialidade) {
		super(id, email, senha, nome, cPF);
		this.area = area;
		this.especialidade = especialidade;
	}
    
	public String getArea() {
		return area;
	}
	
	private void setArea(String area) {
		this.area = area;
	}
	
	public String getEspecialidade() {
		return especialidade;
	}
	private void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}    
}
