package br.ufscar.dc.dsw.LifeCare.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Profissional")
@PrimaryKeyJoinColumn(name="idUsuario")
public class Profissional extends  Usuario {

    @NotBlank(message = "{NotBlank.profissional.cpf}")
    @Size(min = 11, max = 11, message = "{Size.profissional.cpf}")
    @Column(name = "cpf", nullable = false, unique= true, length = 11)
    private String cpf;

    @NotBlank(message = "{NotBlank.profissional.areaConhecimento}")
    @Size(min = 1, max = 120, message = "{Size.profissional.areaConhecimento}")
    @Column(name = "areaConhecimento", nullable = false, unique= false, length = 120)
    private String areaConhecimento;

    @NotBlank(message = "{NotBlank.profissional.qualificacao}")
    @Size(min = 1, max = 120, message = "{Size.profissional.qualificacao}")
    @Column(name = "qualificacao", nullable = false, unique= false, length = 120)
    private String qualificacao;

    public  String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getAreaConhecimento () {return areaConhecimento; }

    public void setAreaConhecimento(String areaConhecimento) {this.areaConhecimento = areaConhecimento; }

    public String getQualificacao() { return qualificacao; }

    public void setQualificacao(String qualificacao) { this.qualificacao = qualificacao; }
}
