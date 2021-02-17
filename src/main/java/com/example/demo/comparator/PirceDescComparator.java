package com.example.demo.comparator;

import com.example.demo.dto.ProductoDTO;

import java.util.Comparator;

public class PirceDescComparator implements Comparator<ProductoDTO> {

    @Override
    public int compare(ProductoDTO o1, ProductoDTO o2) {
        return Integer.valueOf(o2.getPrecio()).compareTo(Integer.valueOf(o1.getPrecio()));
    }
}
