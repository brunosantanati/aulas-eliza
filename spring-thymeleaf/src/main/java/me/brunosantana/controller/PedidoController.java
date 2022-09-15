package me.brunosantana.controller;

import me.brunosantana.dto.RequisicaoNovoPedido;
import me.brunosantana.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@GetMapping("formulario") 
	public String formulario(RequisicaoNovoPedido requisicao) {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
		if(result.hasErrors()) {
			return "pedido/formulario";
		}

		System.out.println(requisicao);
		
		Pedido pedido = requisicao.toPedido();
		System.out.println(pedido);
		
		return "redirect:/hello";
	}
	
}
