package com.plurasight.review;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Reviews")
public class Review {

    private String id;
    private Integer productId;
    private Integer version;
    private List<ReviewEntry> entries = new ArrayList<>();

    public Review(){}

    public Review(Integer productId){
        this.productId = productId;
    }

    public Review(String id, Integer productId){
        this.id = id;
        this.productId = productId;
    }

    public Review(String id, Integer productId, Integer version) {
        this.id = id;
        this.productId = productId;
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<ReviewEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<ReviewEntry> entries) {
        this.entries = entries;
    }
}
