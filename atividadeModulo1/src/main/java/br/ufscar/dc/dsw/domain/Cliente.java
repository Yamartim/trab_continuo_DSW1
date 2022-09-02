package br.ufscar.dc.dsw.domain;

public class Cliente extends BaseUser {
	
	private int adm;
	private String telefone;
    private String sexo;
    private String data_nascimento;
	
	
	public Cliente(Long id, String email, String senha, String nome, String cPF, 
			int adm, String telefone, String sexo, String data_nascimento) {
		
		super(id, email, senha, nome, cPF);
		this.adm = adm;
		this.telefone = telefone;
		this.sexo = sexo;
		this.data_nascimento = data_nascimento;
	}
	public int getAdm() {
		return adm;
	}
	private void setAdm(int adm) {
		this.adm = adm;
	}
	
	public String getTelefone() {
		return telefone;
	}
	private void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getSexo() {
		return sexo;
	}
	private void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getData_nascimento() {
		return data_nascimento;
	}
	private void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
}
