package com.prog4.Ejercicio10.features.clases.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
class ProductoController{

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("POST /productos guarda producto en base real")
    void post_producto_guardaEnBase() throws Exception {

        String body = """
                {
                  "nombre": "Monitor",
                  "precio": 250.0
                }
                """;

        mockMvc.perform(post("/productos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.nombre").value("Monitor"));
    }

    @Test
    @DisplayName("GET /productos/paginado devuelve productos guardados")
    void get_paginado_devuelveProductos() throws Exception {

        String body = """
                {
                  "nombre": "Teclado",
                  "precio": 100.0
                }
                """;

        // primero guardamos
        mockMvc.perform(post("/productos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body));

        // luego consultamos
        mockMvc.perform(get("/productos/paginado")
                        .param("page", "0")
                        .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].nombre").value("Teclado"));
    }
}