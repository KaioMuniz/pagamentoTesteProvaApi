package br.com.kaiomuniz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kaiomuniz.domain.entities.Produto;
import br.com.kaiomuniz.domain.services.ProdutoService;

@RestController
@RequestMapping("api/mercado/v1")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produtos")
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

}
