package me.brunosantana.model;

import me.brunosantana.dto.PedidoDto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Pedido {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeProduto;
	private BigDecimal valorNegociado;
	private LocalDate dataDaEntrega;
	private String urlProduto;
	private String urlImagem;
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private StatusPedido status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public BigDecimal getValorNegociado() {
		return valorNegociado;
	}

	public void setValorNegociado(BigDecimal valorNegociado) {
		this.valorNegociado = valorNegociado;
	}

	public LocalDate getDataDaEntrega() {
		return dataDaEntrega;
	}

	public void setDataDaEntrega(LocalDate dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public StatusPedido getStatus() {
		return status;
	}
	
	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Pedido{" +
				"id=" + id +
				", nomeProduto='" + nomeProduto + '\'' +
				", valorNegociado=" + valorNegociado +
				", dataDaEntrega=" + dataDaEntrega +
				", urlProduto='" + urlProduto + '\'' +
				", urlImagem='" + urlImagem + '\'' +
				", descricao='" + descricao + '\'' +
				", status=" + status +
				'}';
	}

	public PedidoDto toDto() {
		PedidoDto pedidoDto = new PedidoDto();
		pedidoDto.setDescricao(this.getDescricao());
		pedidoDto.setNomeProduto(this.getNomeProduto());
		pedidoDto.setUrlImagem(this.getUrlImagem());
		pedidoDto.setUrlProduto(this.getUrlProduto());
		pedidoDto.setValorNegociado(this.getValorNegociado());
		return pedidoDto;
	}

	public void setarDadosDo(PedidoDto pedidoDto) {
		this.setDescricao(pedidoDto.getDescricao());
		this.setNomeProduto(pedidoDto.getNomeProduto());
		this.setUrlImagem(pedidoDto.getUrlImagem());
		this.setUrlProduto(pedidoDto.getUrlProduto());
		this.setValorNegociado(pedidoDto.getValorNegociado());
	}
}
