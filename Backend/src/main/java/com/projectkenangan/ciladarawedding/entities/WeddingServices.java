package com.projectkenangan.ciladarawedding.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "wedding_services")
public class WeddingServices {
    @Id
    @GenericGenerator(name = "id_weddingservice",strategy = "uuid2")
    @GeneratedValue(generator = "id_weddingservice",strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private Integer price;
    private String detail;

    @OneToMany(mappedBy = "weddingServices")
    @JsonIgnoreProperties(value = {"beauty","dressApparel","foodBeverage","venue","weddingServices"})
    private List<Image> images=new ArrayList<>();

    public WeddingServices() {
    }

    public WeddingServices(String id, String name, Integer price, String detail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.detail = detail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
