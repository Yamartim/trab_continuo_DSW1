package br.ufscar.dc.dsw.LifeCare.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufscar.dc.dsw.LifeCare.domain.Cliente;
import br.ufscar.dc.dsw.LifeCare.service.spec.IClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    IClienteService service;
    
    @Autowired
	private BCryptPasswordEncoder encoder;

    @PostMapping("/salvar")
    public String salvar(@Valid Cliente cliente, BindingResult result, @RequestParam("confirmarSenha") String confirmarSenha, Model model) {
        Boolean error = false;

        if (!cliente.getSenha().equals(confirmarSenha)) {
            model.addAttribute("confirmarSenhaErro", "As senhas estão diferentes");
            error = true;
        }

        if (result.hasErrors() || error) {
            model.addAttribute("result", result);
            return "cadastroCliente";
        }

        cliente.setSenha(encoder.encode(cliente.getSenha()));
        cliente.setTipo("ROLE_cliente");

        service.salvar(cliente);

        return "index";
    }

    
    @GetMapping("/delete/{id}")
    public String excluir(@PathVariable("id") long id){
        service.excluir(id);

        return "redirect:/perfil";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("cliente", service.buscarPorId(id));

        return "admin/formularioEdicaoCliente";
    }

    @PostMapping("/editar")
    public String editar(@Valid Cliente cliente, BindingResult result, @RequestParam("confirmarSenha") String confirmarSenha, Model model){
        Boolean error = false;

        if (!cliente.getSenha().equals(confirmarSenha)) {
            model.addAttribute("confirmarSenhaErro", "As senhas estão diferentes");
            error = true;
        }

        if (result.hasErrors() || error) {
            model.addAttribute("result", result);
            return "admin/formularioEdicaoCliente";
        }

        cliente.setSenha(encoder.encode(cliente.getSenha()));
        service.salvar(cliente);
        return "redirect:/perfil";
    }
}
