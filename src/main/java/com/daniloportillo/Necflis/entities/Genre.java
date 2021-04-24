package com.daniloportillo.Necflis.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "genero")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genre")
    private Long idGenre;

    @Column(name = "nombre")
    private String name;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "fecha")
    private Date dateCreated;


    public Genre() {
    }


    public Genre(Long idGenre, String name, String description, Date dateCreated) {
        this.idGenre = idGenre;
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
    }

    public Long getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Long idGenre) {
        this.idGenre = idGenre;
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
