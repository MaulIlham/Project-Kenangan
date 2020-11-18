package com.projectkenangan.ciladarawedding.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "venue")
public class Venue {
    @Id
    @GenericGenerator(name = "id_venue",strategy = "uuid2")
    @GeneratedValue(generator = "id_venue",strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String address;
    private Integer price;
    private String detail;

    @OneToMany(mappedBy = "venue")
    @JsonIgnoreProperties(value = {"beauty","dressApparel","foodBeverage","venue","weddingServices"})
    private List<Image> images=new ArrayList<>();

    public Venue() {
    }

    public Venue(String id, String name, String address, Integer price, String detail) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.price = price;
        this.detail = detail;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
