package me.brunosantana.controller;

import me.brunosantana.dto.RequisicaoNovoPedido;
import me.brunosantana.model.Pedido;
import me.brunosantana.repository.PedidoRepository;
import org.springframework.stereotype.Controller;
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
	public String novoPedido(RequisicaoNovoPedido requisicao) {
		return "pedido/novo";
	}
	
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
		if(result.hasErrors()) {
			return "pedido/novo";
		}
		
		Pedido pedido = requisicao.toPedido();
		pedidoRepository.save(pedido);
		
		return "redirect:/home";
	}

	@GetMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		pedidoRepository.deleteById(id);
		return "redirect:/home";
	}
	
}
