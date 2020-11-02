package com.projectkenangan.ciladarawedding.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "beauty")
public class Beauty {
    @Id
    @GenericGenerator(name = "id_beauty",strategy = "uuid2")
    @GeneratedValue(generator = "id_beauty",strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private Integer price;
    private String detail;
    private String image;

    public Beauty() {
    }

    public Beauty(String id, String name, Integer price, String detail, String image) {
        this.id = id;
        this.name = name;
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
