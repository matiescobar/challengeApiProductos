package com.example.demo.dao;

import com.example.demo.dto.ArticlesDTO;
import com.example.demo.dto.ProductoDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ProductoDAOImpl implements ProductoDAO{

    private static final String PRODUCTOS_FIlE = "src/main/java/com/example/demo/json/productos.json";

    private List<ProductoDTO> DB;

    private List<ProductoDTO> loadProductos() {

        List<ProductoDTO> productos = null;
        try {
            File file = ResourceUtils.getFile(PRODUCTOS_FIlE);
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<ProductoDTO>> typeReference = new TypeReference<>() {};
            productos = objectMapper.readValue(file, typeReference);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al intentar leer base de datos");
        }

        return productos;
    }

    @Override
    public List<ProductoDTO> getDB(){

        if(DB == null){
            DB = loadProductos();
        }
        return DB;
    }

    @Override
    public void updateDB(List<ArticlesDTO> dto) {
        List<ProductoDTO> db = getDB();

        Map<String, ArticlesDTO> map = dto.stream().collect(
                Collectors.toMap(ArticlesDTO::getProductId, x -> x));

        for(ProductoDTO d : db){
            if(map.get(d.getProductId()) != null
                    && d.getProductId().equals(map.get(d.getProductId()).getProductId())){
                Integer quantity = map.get(d.getProductId()).getQuantity();
                d.setCantidad(d.getCantidad()-quantity);
            }
        }
    }

}
