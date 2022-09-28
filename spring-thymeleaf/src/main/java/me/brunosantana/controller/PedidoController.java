package me.brunosantana.controller;

import me.brunosantana.dto.RequisicaoNovoPedido;
import me.brunosantana.model.Pedido;
import me.brunosantana.repository.PedidoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("pedido")
public class PedidoController{

	private PedidoRepository pedidoRepository;

	public PedidoController(PedidoRepository pedidoRepository){
		this.pedidoRepository = pedidoRepository;
	}

	@GetMapping("formulario") 
	public String formulario(RequisicaoNovoPedido requisicao) {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
		if(result.hasErrors()) {
			return "pedido/formulario";
		}
		
		Pedido pedido = requisicao.toPedido();
		pedidoRepository.save(pedido);
		
		return "redirect:/hello";
	}
	
}
