package br.ufscar.dc.dsw.LifeCare.controller;

import java.text.ParseException;
import java.util.List;

import br.ufscar.dc.dsw.LifeCare.domain.Profissional;
import br.ufscar.dc.dsw.LifeCare.service.spec.IProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class IndexController {

  @Autowired
  IProfissionalService service;

  
  @GetMapping("/")
  public String index(Model model) throws ParseException {
    model.addAttribute("areaConhecimento", "");
    return "index";
  }

  @GetMapping("/buscar")
  public String buscar(
          @RequestParam(name = "areaConhecimento", required = false) String areaConhecimento,
          @RequestParam(name = "areaConhecimento", required = false) String qualificacao,
          Model model) throws ParseException {

    List<Profissional> listaProfissionais = service.buscarPorArea(areaConhecimento);

    model.addAttribute("listaProfissionais", listaProfissionais);

    model.addAttribute("areaConhecimento", areaConhecimento);
    model.addAttribute("areaConhecimento", qualificacao);

    return "index";
  }
}
