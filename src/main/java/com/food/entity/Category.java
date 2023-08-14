package com.food.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Dish> dishList;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
