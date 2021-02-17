package com.example.demo.comparator;

import com.example.demo.dto.ProductoDTO;

import java.util.Comparator;

public class AlphabeticalAscComparator implements Comparator<ProductoDTO> {

    @Override
    public int compare(ProductoDTO o1, ProductoDTO o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
}
