package br.ufscar.dc.dsw.LifeCare.controller;

import java.util.List;

import br.ufscar.dc.dsw.LifeCare.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufscar.dc.dsw.LifeCare.service.spec.*;

@Controller
@RequestMapping("/perfil")
public class PerfilController {
 
  @Autowired
  IUsuarioService usuarioService;

  @Autowired
  IClienteService clienteService;

  @Autowired
  IProfissionalService profissionalService;
  
  @GetMapping("")
  public String onLoad(@RequestParam(name = "vigente", required = false) String vigente, Authentication auth, Model model) {
      String role = auth.getAuthorities().toArray()[0].toString();

      switch (role) {
        case "ROLE_profissional":
        {
          if (vigente != null) {
            System.out.println("opa: " + vigente);
          }
          usuarioService.buscarPorEmail(auth.getName());
          
        }
        break;

        case "ROLE_cliente":
          {
            usuarioService.buscarPorEmail(auth.getName());
          }
          break;
        
        case "ROLE_admin":
           
            List<Profissional> listaProfissional = profissionalService.buscarTodos();
            List<Cliente> listaCliente = clienteService.buscarTodos();
            model.addAttribute("listaProfissional", listaProfissional);
            model.addAttribute("listaCliente", listaCliente);
          break;
      
        default:
          break;
      }

      return "perfil";
  }
}
