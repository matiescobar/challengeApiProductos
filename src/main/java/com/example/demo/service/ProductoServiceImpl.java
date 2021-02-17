package com.example.demo.service;

import com.example.demo.dao.ProductoDAO;
import com.example.demo.dto.ArticlesDTO;
import com.example.demo.dto.ProductoDTO;
import com.example.demo.dto.RequestDTO;
import com.example.demo.dto.RequestPurchaseDTO;
import com.example.demo.exception.BadRequestException;
import com.example.demo.utils.ProductosUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{

    private ProductoDAO productoDAO;

    public ProductoServiceImpl(ProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

    public List<ProductoDTO> getProductosList(RequestDTO requestDTO){

        List<ProductoDTO> dB = productoDAO.getDB();
        List<ProductoDTO> response = new ArrayList<>();

        TypeReference<List<ProductoDTO>> typeReference = new TypeReference<List<ProductoDTO>>() {};
        ObjectMapper objectMapper = new ObjectMapper();
        response = objectMapper.convertValue(dB, typeReference);

        if(isValidRequest(requestDTO)) {
            if(requestDTO.getCategory() != null) {
                response = ProductosUtils.getProductosByCategory(response, requestDTO.getCategory());
            }
            if("sendFree".equals(requestDTO.getFilter())){
               response =  ProductosUtils.getProductosBySendFree(response);
            }
            if(requestDTO.getOrder() != null){
                ProductosUtils.order(response, requestDTO.getOrder());
            }
        } else {
            return dB;
        }

        if(0 == response.size()){
            throw new BadRequestException();
        }

        return response;
    }

    @Override
    public List<ProductoDTO> getProductsByProductId(RequestPurchaseDTO requestDTO){
        List<ProductoDTO> dB = productoDAO.getDB();
        List<ProductoDTO> response = new ArrayList<>();
        response = ProductosUtils.getProductosByProductId(dB, requestDTO);

        if(0 == response.size()){
            throw new BadRequestException();
        }
        return response;
    }

    @Override
    public void updateDB(List<ArticlesDTO> request){
        productoDAO.updateDB(request);
    }

    private boolean isValidRequest(RequestDTO requestDTO){
        return requestDTO.getOrder() != null || requestDTO.getFilter() != null || requestDTO.getCategory() != null;
    }

}
