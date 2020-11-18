package com.projectkenangan.ciladarawedding.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @GenericGenerator(name = "id_image",strategy = "uuid2")
    @GeneratedValue(generator = "id_image",strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String url;

    @ManyToOne()
    @JoinColumn(name = "id_beauty", nullable = false)
    @JsonIgnoreProperties("images")
    private Beauty beauty;

    @ManyToOne()
    @JoinColumn(name = "id_dressapparel", nullable = true)
    @JsonIgnoreProperties("images")
    private DressApparel dressApparel;

    @ManyToOne()
    @JoinColumn(name = "id_foodbaverage", nullable = true)
    @JsonIgnoreProperties("images")
    private FoodBeverage foodBeverage;

    @ManyToOne()
    @JoinColumn(name = "id_venue", nullable = true)
    @JsonIgnoreProperties("images")
    private Venue venue;

    @ManyToOne()
    @JoinColumn(name = "id_weddingservice", nullable = true)
    @JsonIgnoreProperties("images")
    private WeddingServices weddingServices;

    public Image(String name) {
        this.name = name;
    }

    public Image() {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Beauty getBeauty() {
        return beauty;
    }

    public void setBeauty(Beauty beauty) {
        this.beauty = beauty;
    }

    public DressApparel getDressApparel() {
        return dressApparel;
    }

    public void setDressApparel(DressApparel dressApparel) {
        this.dressApparel = dressApparel;
    }

    public FoodBeverage getFoodBeverage() {
        return foodBeverage;
    }

    public void setFoodBeverage(FoodBeverage foodBeverage) {
        this.foodBeverage = foodBeverage;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public WeddingServices getWeddingServices() {
        return weddingServices;
    }

    public void setWeddingServices(WeddingServices weddingServices) {
        this.weddingServices = weddingServices;
    }
}
