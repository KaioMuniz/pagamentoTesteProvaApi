package br.com.kaiomuniz.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kaiomuniz.domain.entities.Produto;
import br.com.kaiomuniz.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }


}
