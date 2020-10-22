package com.projectkenangan.ciladarawedding.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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
    private String image;

    public Venue() {
    }

    public Venue(String id, String name, String address, Integer price, String detail, String image) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.price = price;
        this.detail = detail;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
