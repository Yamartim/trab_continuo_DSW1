package br.ufscar.dc.dsw.LifeCare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufscar.dc.dsw.LifeCare.domain.*;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {
    
    @GetMapping("")
    public String cadastro(){
        return "cadastro";
    }

    @GetMapping("/profissional")
    public String formsProfissional(Profissional profissional){
        return "cadastroProfissional";
    }

    @GetMapping("/cliente")
    public String formsCliente(Cliente cliente){
        return "cadastroCliente";
    }


}
