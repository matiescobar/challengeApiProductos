package com.example.demo.comparator;

import com.example.demo.dto.ProductoDTO;

import java.util.Comparator;

public class AlphabeticalDescComparator implements Comparator<ProductoDTO> {

    @Override
    public int compare(ProductoDTO o1, ProductoDTO o2) {
        return o2.getNombre().compareTo(o1.getNombre());    }
}
