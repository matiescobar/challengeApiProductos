package com.example.demo.utils;

import com.example.demo.comparator.AlphabeticalAscComparator;
import com.example.demo.comparator.AlphabeticalDescComparator;
import com.example.demo.comparator.PirceDescComparator;
import com.example.demo.comparator.PriceAscComparator;
import com.example.demo.converter.ProductoConverter;
import com.example.demo.dto.ProductoDTO;
import com.example.demo.dto.RequestPurchaseDTO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductosUtils {

    public static List<ProductoDTO> getProductosByCategory(List<ProductoDTO> productoDTO, String category){

        List<ProductoDTO> response =
                productoDTO.stream().filter(prod -> prod.getCategoria().equals(category))
                        .collect(Collectors.toList());

        return response;
    }

    public static List<ProductoDTO> getProductosBySendFree(List<ProductoDTO> productoDTO){

        List<ProductoDTO> response =
                productoDTO.stream().filter(prod -> prod.getEnvioGratis().equals("SI"))
                        .collect(Collectors.toList());

        return response;
    }

    public static List<ProductoDTO> getProductosByProductId(List<ProductoDTO> productoDTO, RequestPurchaseDTO requestDTO){

        List<ProductoDTO> response =
                productoDTO.stream().filter(prod -> requestDTO.getProductId().contains(prod.getProductId()))
                        .collect(Collectors.toList());

        return response;
    }

    public static List<ProductoDTO> orderPriceAsc(List<ProductoDTO> productoDTO){

        ProductoConverter.convertToInteger(productoDTO);
        Collections.sort(productoDTO, new PriceAscComparator());

        return ProductoConverter.convertToPrice(productoDTO);
    }

    public static List<ProductoDTO> orderPriceDesc(List<ProductoDTO> productoDTO){

        ProductoConverter.convertToInteger(productoDTO);
        Collections.sort(productoDTO, new PirceDescComparator());

        return ProductoConverter.convertToPrice(productoDTO);
    }

        public static List<ProductoDTO> orderAlphabeticalAsc(List<ProductoDTO> productoDTO){

        Collections.sort(productoDTO, new AlphabeticalAscComparator());
        return productoDTO;
    }

    public static List<ProductoDTO> orderAlphabeticalDesc(List<ProductoDTO> productoDTO){

        Collections.sort(productoDTO, new AlphabeticalDescComparator());
        return productoDTO;
    }

    public static void order(List<ProductoDTO> productoDTO, String order){

        if("0".equals(order)){
            ProductosUtils.orderAlphabeticalAsc(productoDTO);
        } else if ("1".equals(order)){
            ProductosUtils.orderAlphabeticalDesc(productoDTO);
        } else if ("2".equals(order)){
            ProductosUtils.orderPriceDesc(productoDTO);
        } else if ("3".equals(order)){
            ProductosUtils.orderPriceAsc(productoDTO);
        }
    }

}
