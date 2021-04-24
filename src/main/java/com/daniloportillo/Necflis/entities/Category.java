package com.daniloportillo.Necflis.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categoria")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Long idCategory;

    @Column(name = "nombre")
    private String name;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "fecha")
    private Date dateCreated;




    public Category() {
    }


    public Category(Long idCategory, String name, String description, Date dateCreated, Set<Content> contenidos) {
        this.idCategory = idCategory;
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;

    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(@DateTimeFormat(pattern = "yyyy.MM.ddd") Date dateCreated) {
        this.dateCreated = dateCreated;
    }


}
