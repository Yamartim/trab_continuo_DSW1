package br.ufscar.dc.dsw.controller;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

import javax.validation.Valid;

import br.ufscar.dc.dsw.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.ufscar.dc.dsw.domain.Professional;
import br.ufscar.dc.dsw.service.spec.IProfessionalService;
import br.ufscar.dc.dsw.service.spec.IUserService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import br.ufscar.dc.dsw.security.UsuarioDetails;

@Controller
@RequestMapping("/profissionais")
public class ProfessionalController {

    @Autowired
	private IUserService userService;

	@Autowired
	private IProfessionalService professionalService;

    @GetMapping("/cadastrar")
	public String cadastrar(Professional professional) {
		return "profissionais/cadastro";
	}

    @GetMapping("/listar")
	public ResponseEntity<List<Professional>> listar(@RequestParam(required = false) String expertise, @RequestParam(required = false) String knowledgeArea, ModelMap model) {
		List<Professional> professionals = professionalService.buscarTodos();
		model.addAttribute("profissionais", professionals);

		return new ResponseEntity<List<Professional>>(professionals, HttpStatus.OK);
	}

	@GetMapping(value = "/listar/{id}")
	public ResponseEntity listarid(@PathVariable Long id, ModelMap model) {
		Professional professional = professionalService.buscarPorId(id);
		model.addAttribute("profissionais", professional);


		return new ResponseEntity(professional, HttpStatus.OK);

	}

	@GetMapping(value = "/listar/especialidades/{expertise}")
	public ResponseEntity<List<Professional>> listarespec(@PathVariable String expertise, ModelMap model) {
		List<Professional> professionalexp = professionalService.buscarPorExpertise(expertise);
		model.addAttribute("profissionais", professionalexp);


		return new ResponseEntity<List<Professional>>(professionalexp, HttpStatus.OK);

	}

    @PostMapping("/salvar")
	public String salvar(@RequestBody Professional professional, BindingResult result, RedirectAttributes attr, BCryptPasswordEncoder encoder) {
		/*
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		if (fileName == "") {
			attr.addFlashAttribute("fail", "Nao foi possivel cadastrar, verifique os dados e tente novamente");
			return "redirect:/profissionais/listar";
		}
		professional.setQualifications(file.getBytes());
		professional.setFilename(fileName);*/

		if (professional.getRole() == null) {
			professional.setRole("PROF");
		}

		if (result.hasErrors() || professional.getName() == "" || professional.getUsername() == "") {
			attr.addFlashAttribute("fail", "Nao foi possivel cadastrar, verifique os dados e tente novamente");
			return "redirect:/profissionais/listar";
		}


		try {

			professional.setPassword(encoder.encode(professional.getPassword()));
			userService.salvar(professional);
			attr.addFlashAttribute("sucess", "Profissional inserido com sucesso");

			return "redirect:/profissionais/listar";

		}
		catch (Exception handlerException) {
			attr.addFlashAttribute("fail", "Nao foi possivel cadastrar, verifique os dados e tente novamente");
			return "redirect:/profissionais/listar";
		}

	}

    @PutMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("professional", userService.buscarPorId(id));
		return "profissionais/edicao";
	}

    @PutMapping("/editar")
	public String editar(@RequestBody Professional professional, BindingResult result, RedirectAttributes attr,BCryptPasswordEncoder encoder){
			if (professional.getRole() == null) {
				professional.setRole("PROF");
			}

			if (result.hasErrors() || professional.getName() == "" || professional.getUsername() == "") {
			attr.addFlashAttribute("fail", "Nao foi possivel editar, verifique os dados e tente novamente");
			return "redirect:/profissionais/listar";
			}

			try {
				professional.setPassword(encoder.encode(professional.getPassword()));
				userService.salvar(professional);
				attr.addFlashAttribute("sucess", "Profissional editado com sucesso.");
				return "redirect:/profissionais/listar";
			}
			catch (Exception handlerException) {
			attr.addFlashAttribute("fail", "Nao foi possivel editar, verifique os dados e tente novamente");
			return "redirect:/profissionais/listar";
			}
	}

    @DeleteMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        
		userService.excluir(id);
		attr.addFlashAttribute("sucess", "Profissional excluído com sucesso.");
		
		return "redirect:/profissionais/listar";
	}

	@GetMapping(value = "/download/{id}")
	public void download(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Long id) {
		Professional professional= professionalService.buscarPorId(id);

		// set content type
		response.setContentType("application/pdf");

		try {
			// copies all bytes to an output stream
			response.getOutputStream().write(professional.getQualifications());
			
			// flushes output stream
			response.getOutputStream().flush();
		} catch (IOException e) {
			System.out.println("Error :- " + e.getMessage());
			System.out.print("Error :- ");
		}
	}

}
