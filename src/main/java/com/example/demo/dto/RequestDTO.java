package com.example.demo.dto;

import java.util.List;

public class RequestDTO {

    private String category;
    private String filter;
    private String order;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public boolean isValidRequest(){
        return this.getOrder() != null || this.getFilter() != null || this.getCategory() != null;
    }

}
