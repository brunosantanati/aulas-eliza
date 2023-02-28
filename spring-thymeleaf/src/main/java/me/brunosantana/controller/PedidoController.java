package me.brunosantana.controller;

import me.brunosantana.dto.PedidoDto;
import me.brunosantana.model.Pedido;
import me.brunosantana.repository.PedidoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("pedido")
public class PedidoController{

	private PedidoRepository pedidoRepository;

	public PedidoController(PedidoRepository pedidoRepository){
		this.pedidoRepository = pedidoRepository;
	}

	@GetMapping("novo")
	public String novoFormulario(PedidoDto pedidoDto) {
		return "pedido/novo";
	}
	
	@PostMapping("novo")
	public String novo(@Valid PedidoDto pedidoDto, BindingResult result) {
		if(result.hasErrors()) {
			return "pedido/novo";
		}
		
		Pedido pedido = pedidoDto.toPedido();
		pedidoRepository.save(pedido);
		
		return "redirect:/home";
	}

	@GetMapping("editar/{id}")
	public String editarFormulario(@PathVariable("id") long id, Model model) {
		Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id de pedido inválido:" + id));
		PedidoDto pedidoDto = pedido.toDto();
		model.addAttribute("pedidoDto", pedidoDto);
		model.addAttribute("pedidoId", id);
		return "pedido/editar";
	}

	@PostMapping("editar/{id}")
	public String editar(@PathVariable("id") long id, @Valid PedidoDto pedidoDto, BindingResult result) {
		if(result.hasErrors()) {
			return "pedido/editar";
		}

		Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id de pedido inválido:" + id));
		pedido.setarDadosDo(pedidoDto);
		pedidoRepository.save(pedido);

		return "redirect:/home";
	}

	@GetMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		pedidoRepository.deleteById(id);
		return "redirect:/home";
	}
	
}
