package br.ufscar.dc.dsw.domain;

public class BaseUser {
	
	private Long id;
	private String email;
    private String senha;
    private String nome;
    private String CPF;
    
	public BaseUser(Long id, String email, String senha, String nome, String cPF) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		CPF = cPF;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(final String senha) {
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getCPF() {
		return CPF;
	}

	private void setCPF(final String cPF) {
		this.CPF = cPF;
	}
	
}