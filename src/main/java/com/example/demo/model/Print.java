package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "prints")
public class Print {
    private long id;
    private String color;
    private String material;
    private String size;

    public Print() {

    }

    public Print(String color, String material, String size) {
        this.color = color;
        this.material = material;
        this.size = size;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "color", nullable = false)
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Column(name = "material", nullable = false)
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }

    @Column(name = "size", nullable = false)
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Print [id=" + id + ", color=" + color + ", material=" + material + ", size=" + size
                + "]";
    }
}