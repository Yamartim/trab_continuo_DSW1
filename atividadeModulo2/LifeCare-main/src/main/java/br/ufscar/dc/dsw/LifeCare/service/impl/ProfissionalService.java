package br.ufscar.dc.dsw.LifeCare.service.impl;

import java.util.List;

import br.ufscar.dc.dsw.LifeCare.dao.*;
import br.ufscar.dc.dsw.LifeCare.domain.Profissional;
import br.ufscar.dc.dsw.LifeCare.service.spec.IProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false)
public class ProfissionalService implements IProfissionalService {

    @Autowired
    IProfissionalDAO dao;

    @Transactional(readOnly = true)
    public Profissional buscarPorId(Long id){
        return dao.findById(id.longValue());
    }

    @Transactional(readOnly = true)
    public List<Profissional> buscarTodos(){
        return dao.findAll();
    }

    public void salvar(Profissional profissional) {
        dao.save(profissional);
    }

    public List<Profissional> buscarPorArea(String areaConhecimento) {
        if (areaConhecimento != null) {
            return dao.getProfissionalAreaConhecimento(areaConhecimento);
        }

        return dao.findAll();
    }

    public List<Profissional> buscarPorQualificacao(String qualificacao) {
        if (qualificacao != null) {
            return dao.getProfissionalqualificacao(qualificacao);
        }

        return dao.findAll();
    }

    public void excluir(Long id){
        this.buscarPorId(id);

        dao.deleteById(id);
    }
}
