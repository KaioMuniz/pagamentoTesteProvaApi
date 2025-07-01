package br.com.kaiomuniz.domain.entities;

import java.util.UUID;

import lombok.Data;

@Data
public class Produto {

	private UUID id;
	private String nome;
	private Double preco;
	

}
