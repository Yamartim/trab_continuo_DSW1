package br.ufscar.dc.dsw.LifeCare.controller;

import javax.validation.Valid;

import br.ufscar.dc.dsw.LifeCare.domain.Profissional;
import br.ufscar.dc.dsw.LifeCare.service.spec.IProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/profissional")
public class ProfisionalController {

    @Autowired
    IProfissionalService service;

    @Autowired
    private BCryptPasswordEncoder encoder;

    /**
     * @param profissional
     * @param result
     * @param confirmarSenha
     * @param model
     * @return
     */
    @PostMapping("/salvar")
    public String salvar(@Valid Profissional profissional, BindingResult result, @RequestParam("confirmarSenha") String confirmarSenha, Model model) {
        Boolean error = false;
        if (!profissional.getSenha().equals(confirmarSenha)) {
            model.addAttribute("confirmarSenhaErro", "As senhas estão diferentes");
            error = true;
        }

        if (result.hasErrors() || error) {
            model.addAttribute("result", result);
            return "cadastroProfissional";
        }

        profissional.setSenha(encoder.encode(profissional.getSenha()));
        profissional.setTipo("ROLE_profissional");

        service.salvar(profissional);

        return "index";
    }

    @GetMapping("/delete/{id}")
    public String excluir(@PathVariable("id") long id){
        service.excluir(id);

        return "redirect:/perfil";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("profissional", service.buscarPorId(id));

        return "admin/formularioEdicaoProfissional";
    }

    @PostMapping("/editar")
    public String editar(@Valid Profissional profissional, BindingResult result, @RequestParam("confirmarSenha") String confirmarSenha, Model model){
        Boolean error = false;
        if (!profissional.getSenha().equals(confirmarSenha)) {
            model.addAttribute("confirmarSenhaErro", "As senhas estão diferentes");
            error = true;
        }

        if (result.hasErrors() || error) {
            model.addAttribute("result", result);
            return "admin/formularioEdicaoProfissional";
        }

        profissional.setSenha(encoder.encode(profissional.getSenha()));
        service.salvar(profissional);
        return "redirect:/perfil";
    }
}
