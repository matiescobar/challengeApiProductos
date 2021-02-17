package com.example.demo.controller;

import com.example.demo.dto.ArticlesDTO;
import com.example.demo.dto.ProductoDTO;
import com.example.demo.dto.RequestDTO;
import com.example.demo.dto.RequestPurchaseDTO;
import com.example.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ArticlesController {


    ProductoService productoService;

    public ArticlesController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/articles")
    @ResponseBody
    public List<ProductoDTO> getProductsList(RequestDTO requestDTO){

        return productoService.getProductsList(requestDTO);
    }

    @GetMapping("/articlesByProductId")
    @ResponseBody
    public List<ProductoDTO> getProductosByProductId(RequestPurchaseDTO requestDTO){

        return productoService.getProductsByProductId(requestDTO);
    }

    @PutMapping("/updateDb")
    public void updateDB(@RequestBody List<ArticlesDTO> request){
        productoService.updateDB(request);
    }

}
