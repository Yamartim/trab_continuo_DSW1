package br.ufscar.dc.dsw.LifeCare.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

    @Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

    @NotBlank(message = "{NotBlank.user.nome}")
    @Size(max = 60)
    @Column(name = "nome", nullable = false, length = 60)
    private String nome;

    @NotBlank(message = "{NotBlank.user.email}")
    @Size(max = 60)
    @Column(name = "email", nullable = false, unique = true, length = 60)
    private String email;

    @NotBlank(message = "{NotBlank.user.senha}")
    @Size(min = 4, max = 60)
    @Column(name = "senha", nullable = false, length = 60)
    private String senha;

    @Size(max = 60)
    @Column(name= "tipo", nullable = false, length = 60)
    private String tipo;

    @Column(nullable = false)
    private boolean enabled;

    public Long getId() {
	return id;
    }
    public void setId(Long id) {
	this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
