package com.example.demo.service;

import com.example.demo.dto.ArticlesDTO;
import com.example.demo.dto.ProductoDTO;
import com.example.demo.dto.RequestDTO;
import com.example.demo.dto.RequestPurchaseDTO;

import java.io.IOException;
import java.util.List;

public interface ProductoService {

    List<ProductoDTO> getProductosList(RequestDTO requestDTO);
    List<ProductoDTO> getProductsByProductId(RequestPurchaseDTO requestDTO);
    void updateDB(List<ArticlesDTO> request);

}
