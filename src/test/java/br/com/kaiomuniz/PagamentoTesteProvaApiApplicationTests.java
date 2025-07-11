package br.com.kaiomuniz;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import br.com.kaiomuniz.domain.entities.Produto;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PagamentoTesteProvaApiApplicationTests {

    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper mapper;

    @Test
    @Order(1)
    void deveListarProdutosComSucesso() throws Exception {
        // Realizando a requisição para listar os produtos
        mockMvc.perform(
            get("/api/mercado/v1/produtos")
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk()) // Espera o status HTTP 200
        .andDo(result -> {
            var json = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
            var produtos = mapper.readValue(json, new TypeReference<List<Produto>>() {}); // Deserializando a resposta para a lista de Produto

            assertNotNull(produtos); // A lista de produtos não pode ser nula
            assertTrue(produtos.size() > 0); // Verifica se a lista contém produtos
        });
    }
}
