package me.brunosantana.dto;

import me.brunosantana.model.Pedido;
import me.brunosantana.model.StatusPedido;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PedidoDto {

	@NotBlank //NotBlank.pedidoDto.nomeProduto=não pode estar em branco
	@Size(min = 3, max = 50)
	private String nomeProduto;
	
	@NotBlank
	private String urlProduto;
	
	@NotBlank
	private String urlImagem;

	private BigDecimal valorNegociado;

	private String descricao;
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getUrlProduto() {
		return urlProduto;
	}
	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public BigDecimal getValorNegociado() { return valorNegociado; }
	public void setValorNegociado(BigDecimal valorNegociado) { this.valorNegociado = valorNegociado; }
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setDescricao(descricao);
		pedido.setNomeProduto(nomeProduto);
		pedido.setUrlImagem(urlImagem);
		pedido.setUrlProduto(urlProduto);
		pedido.setValorNegociado(valorNegociado);
		pedido.setStatus(StatusPedido.AGUARDANDO);
		pedido.setDataDaEntrega(LocalDate.now().plusDays(7));
		return pedido;
	}

	@Override
	public String toString() {
		return "PedidoDto{" +
				"nomeProduto='" + nomeProduto + '\'' +
				", urlProduto='" + urlProduto + '\'' +
				", urlImagem='" + urlImagem + '\'' +
				", valorNegociado=" + valorNegociado +
				", descricao='" + descricao + '\'' +
				'}';
	}
}
