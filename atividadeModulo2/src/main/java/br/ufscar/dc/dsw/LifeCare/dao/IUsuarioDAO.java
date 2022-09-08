package br.ufscar.dc.dsw.LifeCare.dao;


import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.LifeCare.domain.Usuario;

@SuppressWarnings("unchecked")
public interface IUsuarioDAO extends CrudRepository<Usuario, Long> {

    public Usuario findByEmail(String email);
    
}
