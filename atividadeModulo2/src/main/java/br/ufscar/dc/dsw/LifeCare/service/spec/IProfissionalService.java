package br.ufscar.dc.dsw.LifeCare.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.LifeCare.domain.Profissional;

public interface IProfissionalService {

    Profissional buscarPorId(Long id);

    List<Profissional> buscarTodos();

    List<Profissional> buscarPorArea(String areaConhecimento );
    List<Profissional> buscarPorQualificacao(String qualificacao);

    void salvar(Profissional profissional);

    void excluir(Long id);

}
