package br.com.kaiomuniz.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kaiomuniz.domain.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

}
