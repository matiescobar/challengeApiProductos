package com.example.demo.converter;

import com.example.demo.dto.ProductoDTO;

import java.util.List;

public class ProductoConverter {

    public static List<ProductoDTO> convertToInteger(List<ProductoDTO> productoDTO){

        for(ProductoDTO p : productoDTO){
           p.setPrecio(p.getPrecio().replace("$", "").replace(".", ""));
        }

        return productoDTO;
    }

    public static List<ProductoDTO> convertToPrice(List<ProductoDTO> productoDTO){

        for(ProductoDTO p : productoDTO){

            String price = String.format("%,d", Integer.valueOf(p.getPrecio()));
            p.setPrecio("$" + price.replace(",", "."));
        }

        return productoDTO;
    }

}
