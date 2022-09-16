package br.ufscar.dc.dsw.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.domain.Client;
import br.ufscar.dc.dsw.service.spec.IClientService;
import br.ufscar.dc.dsw.service.spec.IUserService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import br.ufscar.dc.dsw.security.UsuarioDetails;

@Controller
@RequestMapping("/clientes")
public class ClientController {

	@Autowired
	private IClientService clientService;

	@Autowired 
	private IUserService userService;

	@GetMapping("/cadastrar")
	public String cadastrar(Client client) {

		return "cliente/cadastro";
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Client>> listar(ModelMap model) {
		List<Client> clients = clientService.buscarTodos();
		model.addAttribute("clientes", clients);


		return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);

	}

	@GetMapping(value = "/listar/{id}")
	public ResponseEntity listarid(@PathVariable Long id, ModelMap model) {
		Client client = clientService.buscarPorId(id);
		model.addAttribute("clientes", client);


		return new ResponseEntity(client, HttpStatus.OK);

	}

	@PostMapping("/salvar")
	public String salvar(@RequestBody  Client client, BindingResult result, RedirectAttributes attr, BCryptPasswordEncoder encoder) {

		if (client.getRole() == null) {
			client.setRole("CLIENT");
		}

		if (result.hasErrors() || client.getName() == "" || client.getUsername() == "") {
			attr.addFlashAttribute("fail", "Nao foi possivel cadastrar, verifique os dados e tente novamente");
			return "redirect:/clientes/listar";
		}

		try {

			client.setPassword(encoder.encode(client.getPassword()));
			userService.salvar(client);
			attr.addFlashAttribute("sucess", "Cliente inserido com sucesso.");

			return "redirect:/clientes/listar";
		}
		catch (Exception handlerException) {
			attr.addFlashAttribute("fail", "Nao foi possivel cadastrar, verifique os dados e tente novamente");
			return "redirect:/clientes/listar";
		}
	}
	
	@PutMapping("/editar")
	public String editar(@RequestBody Client client, BindingResult result, RedirectAttributes attr, BCryptPasswordEncoder encoder) {
		if (client.getRole() == null) {
			client.setRole("CLIENT");
		}

		if (result.hasErrors() || client.getName() == "" || client.getUsername() == "") {
			attr.addFlashAttribute("fail", "Nao foi possivel editar, verifique os dados e tente novamente");
			return "redirect:/clientes/listar";
		}

		try {
			client.setPassword(encoder.encode(client.getPassword()));
			userService.salvar(client);
			attr.addFlashAttribute("sucess", "Cliente editado com sucesso.");
			return "redirect:/clientes/listar";
		}
		catch (Exception handlerException) {
			attr.addFlashAttribute("fail", "Nao foi possivel editar, verifique os dados e tente novamente");
			return "redirect:/clientes/listar";
		}
	}

	@PutMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("client", userService.buscarPorId(id));
		return "cliente/edicao";
	}

	@DeleteMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		userService.excluir(id);
		attr.addFlashAttribute("sucess", "Cliente excluído com sucesso.");
		
		return "redirect:/clientes/listar";
	}
}
