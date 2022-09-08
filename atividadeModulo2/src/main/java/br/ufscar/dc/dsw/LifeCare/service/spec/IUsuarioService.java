package br.ufscar.dc.dsw.LifeCare.service.spec;


import br.ufscar.dc.dsw.LifeCare.domain.Usuario;

public interface IUsuarioService {
    
    public Usuario buscarPorEmail(String email);
}
