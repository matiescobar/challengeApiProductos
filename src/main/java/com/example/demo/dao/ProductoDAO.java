package com.example.demo.dao;

import com.example.demo.dto.ArticlesDTO;
import com.example.demo.dto.ProductoDTO;

import java.util.List;

public interface ProductoDAO {

    List<ProductoDTO> getDB();
    void updateDB(List<ArticlesDTO> dto);
}
