package com.example.demo;

import com.example.demo.controller.ArticlesController;
import com.example.demo.dao.ProductoDAO;
import com.example.demo.dao.ProductoDAOImpl;
import com.example.demo.dto.ProductoDTO;
import com.example.demo.dto.RequestDTO;
import com.example.demo.service.ProductoService;
import com.example.demo.service.ProductoServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assert;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class DesafioSpringTests {

    @Autowired
    private ProductoService productoService;

    @MockBean
    private ProductoDAO productoDAO;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUps(){
        initMocks(this);
        productoService = new ProductoServiceImpl(productoDAO);
    }

    @Test
    void shouldReturnFourProducts() throws Exception {

        //List<ProductoDTO> expected = getProductos();
        //when(productoDAO.getDB()).thenReturn(expected);
        //List<ProductoDTO> response = productoService.getProductosList(new RequestDTO());
        //assertThat(expected).isEqualTo(response);

        List<ProductoDTO> expected = getProductos();
        when(productoDAO.getDB()).thenReturn(expected);
        //verify(productoDAO, atLeastOnce()).getDB();
        mockMvc.perform(get("/api/v1/articles")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(expected)));
    }

    @Test
    void shouldReturnTwoHerramientas() throws Exception {

        List<ProductoDTO> listDB = getProductos();
        List<ProductoDTO> expected = getProductosHerramientas();

        when(productoDAO.getDB()).thenReturn(listDB);
        mockMvc.perform(get("/api/v1/articles").queryParam("category", "Herramientas"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(expected)));
    }

    @Test
    void shouldReturnTwoHerramientasWithSendFree() throws Exception {

        List<ProductoDTO> listDB = getProductosPunto3();

        List<ProductoDTO> productoList = new ArrayList<>();
        ProductoDTO productoDTO1 = new ProductoDTO();
        productoDTO1.setNombre("Desmalezadora");
        productoDTO1.setCategoria("Herramientas");
        productoDTO1.setEnvioGratis("SI");
        productoList.add(productoDTO1);

        ProductoDTO productoDTO2 = new ProductoDTO();
        productoDTO2.setNombre("Taladro");
        productoDTO2.setCategoria("Herramientas");
        productoDTO2.setEnvioGratis("SI");
        productoList.add(productoDTO2);

        when(productoDAO.getDB()).thenReturn(listDB);
        mockMvc.perform(get("/api/v1/articles")
        .queryParam("category", "Herramientas")
        .queryParam("filter", "sendFree"))
        .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(productoList)));

    }

    public List<ProductoDTO> getProductos(){

        List<ProductoDTO> productoList = new ArrayList<>();

        ProductoDTO productoDTO1 = new ProductoDTO();
        productoDTO1.setNombre("Desmalezadora");
        productoDTO1.setCategoria("Herramientas");
        productoDTO1.setCantidad(5);
        productoDTO1.setPrecio("$9.600");
        productoList.add(productoDTO1);

        ProductoDTO productoDTO2 = new ProductoDTO();
        productoDTO2.setNombre("Taladro");
        productoDTO2.setCategoria("Herramientas");
        productoDTO2.setCantidad(2);
        productoDTO2.setPrecio("$1.600");
        productoList.add(productoDTO2);

        ProductoDTO productoDTO3 = new ProductoDTO();
        productoDTO3.setNombre("Soldadora");
        productoDTO3.setCategoria("Zapatillas");
        productoDTO3.setCantidad(3);
        productoDTO3.setPrecio("$10.600");
        productoList.add(productoDTO3);

        ProductoDTO productoDTO4 = new ProductoDTO();
        productoDTO4.setNombre("Zapatillas Deportivas");
        productoDTO4.setCategoria("Zapatillas");
        productoDTO4.setCantidad(7);
        productoDTO4.setPrecio("$20.600");
        productoList.add(productoDTO4);

        return productoList;
    }

    public List<ProductoDTO> getProductosHerramientas() {

        List<ProductoDTO> productoList = new ArrayList<>();

        ProductoDTO productoDTO1 = new ProductoDTO();
        productoDTO1.setNombre("Desmalezadora");
        productoDTO1.setCategoria("Herramientas");
        productoDTO1.setCantidad(5);
        productoDTO1.setPrecio("$9.600");
        productoList.add(productoDTO1);

        ProductoDTO productoDTO2 = new ProductoDTO();
        productoDTO2.setNombre("Taladro");
        productoDTO2.setCategoria("Herramientas");
        productoDTO2.setCantidad(2);
        productoDTO2.setPrecio("$1.600");
        productoList.add(productoDTO2);

        return productoList;
    }

    public List<ProductoDTO> getProductosPunto3(){

        List<ProductoDTO> productoList = new ArrayList<>();

        ProductoDTO productoDTO1 = new ProductoDTO();
        productoDTO1.setNombre("Desmalezadora");
        productoDTO1.setCategoria("Herramientas");
        productoDTO1.setEnvioGratis("SI");
        productoList.add(productoDTO1);

        ProductoDTO productoDTO2 = new ProductoDTO();
        productoDTO2.setNombre("Taladro");
        productoDTO2.setCategoria("Herramientas");
        productoDTO2.setEnvioGratis("SI");
        productoList.add(productoDTO2);

        ProductoDTO productoDTO3 = new ProductoDTO();
        productoDTO3.setNombre("Soldadora");
        productoDTO3.setCategoria("Herramientas");
        productoDTO3.setEnvioGratis("NO");
        productoList.add(productoDTO3);

        ProductoDTO productoDTO4 = new ProductoDTO();
        productoDTO4.setNombre("Zapatillas Deportivas");
        productoDTO4.setCategoria("Zapatillas");
        productoDTO4.setEnvioGratis("NO");
        productoList.add(productoDTO4);

        ProductoDTO productoDTO5 = new ProductoDTO();
        productoDTO5.setNombre("Zapatillas Deportivas");
        productoDTO5.setCategoria("Zapatillas");
        productoDTO5.setEnvioGratis("SI");
        productoList.add(productoDTO5);

        ProductoDTO productoDTO6 = new ProductoDTO();
        productoDTO6.setNombre("Zapatillas Deportivas");
        productoDTO6.setCategoria("Zapatillas");
        productoDTO6.setEnvioGratis("SI");
        productoList.add(productoDTO6);

        ProductoDTO productoDTO7 = new ProductoDTO();
        productoDTO7.setNombre("Zapatillas Deportivas");
        productoDTO7.setCategoria("Zapatillas");
        productoDTO7.setEnvioGratis("NO");
        productoList.add(productoDTO7);

        ProductoDTO productoDTO8 = new ProductoDTO();
        productoDTO8.setNombre("Zapatillas Deportivas");
        productoDTO8.setCategoria("Zapatillas");
        productoDTO8.setEnvioGratis("SI");
        productoList.add(productoDTO8);

        return productoList;
    }
}
