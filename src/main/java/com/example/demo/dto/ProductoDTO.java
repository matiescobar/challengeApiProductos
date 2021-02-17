package com.example.demo.dto;

public class ProductoDTO {

    private String nombre;
    private String productId;
    private String categoria;
    private String marca;
    private String precio;
    private Integer cantidad;
    private String envioGratis;
    private String prestigio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getEnvioGratis() {
        return envioGratis;
    }

    public void setEnvioGratis(String envioGratis) {
        this.envioGratis = envioGratis;
    }

    public String getPrestigio() {
        return prestigio;
    }

    public void setPrestigio(String prestigio) {
        this.prestigio = prestigio;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
