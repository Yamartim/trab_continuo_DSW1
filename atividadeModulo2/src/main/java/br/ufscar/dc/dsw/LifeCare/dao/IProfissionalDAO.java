package br.ufscar.dc.dsw.LifeCare.dao;

import java.util.List;

import br.ufscar.dc.dsw.LifeCare.domain.Profissional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IProfissionalDAO extends CrudRepository<Profissional, Long> {

    Profissional findById(long id);

    List<Profissional> findAll();

    Profissional save(Profissional profissional);

    @Query("from Profissional p where p.areaConhecimento=:areaConhecimento")
    List<Profissional> getProfissionalAreaConhecimento(String areaConhecimento);

    @Query("from Profissional p where p.qualificacao=:qualificacao")
    List<Profissional> getProfissionalqualificacao(@Param("qualificacao") String qualificacao);

    void deleteById(Long id);

}
